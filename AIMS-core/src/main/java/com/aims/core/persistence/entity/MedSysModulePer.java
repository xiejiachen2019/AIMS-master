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
 * 角色对应的权限关联表
 * </p>
 *
 * @author XIE JIACHEN
 * @since 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MedSysModulePer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统编号
     */
    @TableId(value = "sysno", type = IdType.AUTO)
    private Long sysno;

    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 权限代码
     */
    private String perCode;

    /**
     * 权限名称
     */
    private String perName;

    /**
     * 所属模块代码
     */
    private String moduleCode;

    /**
     * 所属模块名称
     */
    private String moduleName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 路径
     */
    private String moduleUrl;

    /**
     * 状态值0启用 1禁用
     */
    private Integer status;

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
     * 更新操作人员
     */
    private String updator;


}