package com.aims.ser.config;

import com.aims.ser.filter.CosFilter;
import com.aims.ser.filter.JWTAuthenticationFilter;
import com.aims.ser.filter.JWTLoginFilter;
import com.aims.ser.security.CustomAuthenticationProvider;
import com.aims.ser.security.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 */
@Configuration
@EnableWebSecurity  //开启安全框架功能
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CosFilter cosFilter;

    /**
     * 需要放行的URL
     */
    private static final String[] AUTH_WHITELIST = {
            // -- register url
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };

    @Autowired
    private UserDetailsService userDetailsService;

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 测试用资源，需要验证了的用户才能访问
                //.antMatchers("/tasks/**").authenticated()
                //.antMatchers(HttpMethod.DELETE, "/tasks/**").hasRole("ADMIN")
                // 其他都放行了
                .anyRequest().permitAll()
                .and()
                .addFilterBefore(cosFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                // 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 加一句这个
                .exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint())
        ;
        /*http
                //request 设置
                .authorizeRequests()   //http.authorizeRequests() 方法中的自定义匹配
                .antMatchers("/resources/**", "/signup", "/about").permitAll() // 指定所有用户进行访问指定的url
                .antMatchers("/admin/**").hasRole("ADMIN")  //指定具有特定权限的用户才能访问特定目录，hasRole()方法指定用户权限，且不需前缀 “ROLE_“
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")//
                .anyRequest().authenticated()  //任何请求没匹配的都需要进行验证
                .and()        //login设置  自定义登录页面且允许所有用户登录
                .formLogin()
                .loginPage("/login") //The updated configuration specifies the location of the log in page  指定自定义登录页面
                .permitAll(); // 允许所有用户访问登录页面. The formLogin().permitAll() 方法
                 .and
                .logout()  //logouts 设置
                .logoutUrl("/my/logout")  // 指定注销路径
                .logoutSuccessUrl("/my/index") //指定成功注销后跳转到指定的页面
                .logoutSuccessHandler(logoutSuccessHandler)  //指定成功注销后处理类 如果使用了logoutSuccessHandler()的话， logoutSuccessUrl()就会失效
                .invalidateHttpSession(true)  // httpSession是否有效时间，如果使用了 SecurityContextLogoutHandler，其将被覆盖
                .addLogoutHandler(logoutHandler)  //在最后增加默认的注销处理类LogoutHandler
                .deleteCookies(cookieNamesToClear);//指定注销成功后remove cookies
        //增加在FilterSecurityInterceptor前添加自定义的myFilterSecurityInterceptor
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);*/
    }

    // 该方法是登录的时候会进入
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService));
    }
}
