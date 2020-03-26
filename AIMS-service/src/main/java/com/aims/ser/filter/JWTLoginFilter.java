package com.aims.ser.filter;

import com.aims.common.utils.StringUtil;
import com.aims.core.exception.CommonErrorCode;
import com.aims.core.exception.ResultPO;
import com.aims.model.LoginUserDto;
import com.aims.ser.security.JwtHelper;
import com.aims.ser.security.ResponseRender;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @author zhaoxinguo on 2017/9/12.
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/aims/login");  //设置登录地址
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            LoginUserDto loginUser = new ObjectMapper().readValue(req.getInputStream(), LoginUserDto.class);
            checkLoginInfo(loginUser, res);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getLoginName(),
                            loginUser.getLoginPwd(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkLoginInfo(LoginUserDto loginUser, HttpServletResponse res) throws IOException {
        if (StringUtil.isBlank(loginUser.getLoginName()) || StringUtil.isBlank(loginUser.getLoginPwd())) {
            ResponseRender.renderResponse(res, new ResultPO(CommonErrorCode.E100001.getCode(), "用户名或密码不正确"));
        }
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // builder the token
        String token;
        try {
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            // 定义存放角色集合的对象
            StringBuilder sb = new StringBuilder();
            for (GrantedAuthority grantedAuthority : authorities) {
                sb.append(grantedAuthority.getAuthority()).append(",");
            }
            String subject = auth.getPrincipal() + "-" + sb;
            token = "Bearer " + JwtHelper.generateToken(subject);
            // 登录成功后，返回token到header里面
            response.addHeader(JwtHelper.header, token);

            ResponseRender.renderResponse(response, ResultPO.success(token));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 验证失败时候调用的方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        logger.error("authentication failed, reason: " + failed.getMessage());
        ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E100014.getCode(), failed.getMessage()));
    }
}
