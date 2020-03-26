package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
    * 用户信息表用于医生、护士登录
    * </p>
*
* @author XIE JIACHEN
* @since 2020-03-25
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class MedSysUser implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 系统编号
            */
            @TableId(value = "sysno", type = IdType.AUTO)
    private Long sysno;

            /**
            * 用户id
            */
    private String userId;

            /**
            * 登录账号/唯一
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
            * 角色id
            */
    private String roleCode;

            /**
            * 用户状态(0启用1禁用)
            */
    private Boolean status;

            /**
            * 职称
            */
    private String memo;

            /**
            * 创建时间
            */
    private LocalDateTime createTime;

            /**
            * 更新时间
            */
    private LocalDateTime updateTime;

            /**
            * 创建人
            */
    private String creator;

            /**
            * 更新操作人
            */
    private String updator;


}