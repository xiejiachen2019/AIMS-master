package com.aims.ser.security;

import com.aims.model.SysUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/9/19 13:16
 **/
public class SecurityUserHelper {

    private static Logger logger = LoggerFactory.getLogger(SecurityUserHelper.class);

    /**
     * 获取认证信息
     * @return
     */
    public static Authentication getCurrentUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户
     * @return
     */
    public static SysUserDto getCurrentUser(){
        String userInfo = getCurrentUserAuthentication().getPrincipal().toString();
        logger.info(">>>>>>current user authentication info：["+userInfo+"]<<<<<<");
        String[] userInfoSet = userInfo.split(",");
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setUserId(userInfoSet[0]);
        sysUserDto.setLoginName(userInfoSet[1]);
        sysUserDto.setUserName(userInfoSet[2]);
        return sysUserDto;
    }

    /**
     * 获取当前用户角色（角色ID集合）
     * @return
     */
    public static List<String> getCurrentRole() {
        List<GrantedAuthority> roleList = (List<GrantedAuthority>) getCurrentUserAuthentication().getAuthorities();
        if (null == roleList || roleList.size() == 0) {
            return null;
        }
        List<String> roles = new ArrayList<>(roleList.size());
        for (GrantedAuthority grantedAuthority : roleList) {
            roles.add(grantedAuthority.getAuthority());
        }
        return roles;
    }
}
