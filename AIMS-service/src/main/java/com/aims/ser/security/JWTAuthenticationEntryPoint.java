package com.aims.ser.security;

import com.aims.core.exception.CommonErrorCode;
import com.aims.core.exception.ResultPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/9/18 14:57
 **/
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private Logger logger = LoggerFactory.getLogger(JWTAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.error(e.getMessage());
        ResponseRender.renderResponse(httpServletResponse, new ResultPO(CommonErrorCode.E100000));
    }
}
