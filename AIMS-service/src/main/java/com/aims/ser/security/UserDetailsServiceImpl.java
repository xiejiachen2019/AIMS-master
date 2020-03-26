package com.aims.ser.security;

import com.aims.ser.service.SysUserService;
import com.aims.model.SysUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录认证时通过该类查询用户信息
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserDto sysUserDto = sysUserService.selectByUserName(username);
        if(sysUserDto == null){
            throw new UsernameNotFoundException("无效的用户或用户不存在");
        }
        List<GrantedAuthority> roleList = new ArrayList<>();
        if (sysUserDto.getRoleCode().contains(",")) {    //这边if和else的逻辑是不是反了？
            roleList.add(new GrantedAuthorityImpl(sysUserDto.getRoleCode()));
        } else {
            String[] roles = sysUserDto.getRoleCode().split(",");
            for (String role : roles) {
                roleList.add(new GrantedAuthorityImpl(role));
            }
        }
        JwtUser jwtUser = new JwtUser(sysUserDto.getUserId(), sysUserDto.getLoginName(),
                sysUserDto.getLoginPwd(), sysUserDto.getSalt(), roleList);
        jwtUser.setUName(sysUserDto.getUserName());
        return jwtUser;
    }

}
