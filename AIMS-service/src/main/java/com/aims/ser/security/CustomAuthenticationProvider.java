package com.aims.ser.security;

import com.aims.common.utils.MD5;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 自定义身份认证验证组件
 *
 * @author zhaoxinguo on 2017/9/12.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String loginName = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 认证逻辑
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(loginName);
        if (null != jwtUser) {
            // 对传入的明文密码进行加密
            password = MD5.getMD5(password + jwtUser.getSalt());
            if (password.equals(jwtUser.getPassword())) {
                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                String userInfo = jwtUser.getUserId() + "," + jwtUser.getLoginName() + "," + jwtUser.getUName();
                Authentication auth = new UsernamePasswordAuthenticationToken(userInfo, password, jwtUser.getAuthorities());
                return auth;
            } else {
                throw new BadCredentialsException("密码错误");
            }
        } else {
            throw new UsernameNotFoundException("无效的用户或用户不存在");
        }
    }

    /**
     * 是否可以提供输入类型的认证服务
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
