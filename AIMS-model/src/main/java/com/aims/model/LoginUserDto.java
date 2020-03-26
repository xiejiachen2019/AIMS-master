package com.aims.model;

import lombok.Data;

/**
 * @Description
 * @Author Jerry
 * @Date 2019/9/18 9:22
 **/
@Data
public class LoginUserDto {

    /**
     * 登录账号
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String loginPwd;
}
