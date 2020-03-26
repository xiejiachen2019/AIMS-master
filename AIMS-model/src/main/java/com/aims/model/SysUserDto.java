package com.aims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author Cao
 * @Date 2019/9/16
 **/
@Data
public class SysUserDto implements Serializable {

    private Long sysno;

    /**
     * 用户id
     */
    private String userId;
    /**
     * 登录账号
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String loginPwd;
    /**
     * 加密key
     */
    private String salt;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户所在部门id
     */
    private String deptId;
    /**
     * 角色code
     */
    private String roleCode;
    /**
     * 用户状态(0启用1禁用)
     */
    private Integer status;
    /**
     * 备注
     */
    private String memo;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 更新操作人
     */
    private String updator;
}
