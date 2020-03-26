package com.aims.core.persistence.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author XIE JIACHEN
 * @since 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MedSysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统编号
     */
    @TableId(value = "sysno", type = IdType.AUTO)
    private Long sysno;

    /**
     * 权限代码
     */
    private String perCode;

    /**
     * 权限名称
     */
    private String perName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 所属模块代码
     */
    private String moduleCode;

    /**
     * 所属模块名称
     */
    private String moduleName;

    /**
     * 路径
     */
    private String moduleUrl;

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