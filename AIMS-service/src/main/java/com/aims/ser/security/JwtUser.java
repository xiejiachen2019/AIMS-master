package com.aims.ser.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/9/18 10:58
 **/
@Data
public class JwtUser implements UserDetails {

    private String userId;

    private String loginName;

    private String uName;

    private String password;

    private String salt;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(String userId, String loginName, String password, String salt, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.salt = salt;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未被锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
