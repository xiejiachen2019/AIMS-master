package com.aims.ser.filter;

import com.aims.core.exception.AIMSException;
import com.aims.core.exception.CommonErrorCode;
import com.aims.core.exception.ResultPO;
import com.aims.ser.security.GrantedAuthorityImpl;
import com.aims.ser.security.JwtHelper;
import com.aims.ser.security.ResponseRender;




import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 自定义JWT认证过滤器
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JwtHelper.header);
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        String token = request.getHeader(JwtHelper.header);
        if (token == null || token.isEmpty()) {
            logger.error("token为空");
            throw new AIMSException(CommonErrorCode.E100015);
        }
        // parse the token.
        String subject;
        try {
            subject = JwtHelper.getClaimsFromToken(token.replace("Bearer ", "")).getSubject();
            long end = System.currentTimeMillis();
            logger.info("执行时间: {}", (end - start) + " 毫秒");
            if (subject != null) {
                String[] userRole = subject.split("-");
                String[] split = userRole[1].split(",");
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                for (int i=0; i < split.length; i++) {
                    authorities.add(new GrantedAuthorityImpl(split[i]));
                }
                return new UsernamePasswordAuthenticationToken(userRole[0], null, authorities);
            }
        } catch (ExpiredJwtException e) {
            logger.error("Token已过期: {} " + e);
            ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E100012));
        } catch (UnsupportedJwtException e) {
            logger.error("Token格式错误: {} " + e);
            ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E100015));
        } catch (MalformedJwtException e) {
            logger.error("Token没有被正确构造: {} " + e);
            ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E100015));
        } catch (SignatureException e) {
            logger.error("签名失败: {} " + e);
            ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E100015));
        } catch (IllegalArgumentException e) {
            logger.error("非法参数异常: {} " + e);
            ResponseRender.renderResponse(response, new ResultPO(CommonErrorCode.E100015));
        }
        return null;
    }

}
