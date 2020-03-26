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
    * 菜单模块表：涵盖顶部菜单项
    * </p>
*
* @author XIE JIACHEN
* @since 2020-03-25
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class MedSysModule implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 系统编号
            */
            @TableId(value = "sysno", type = IdType.AUTO)
    private Long sysno;

            /**
            * 模块代码
            */
    private String code;

            /**
            * 模块名称
            */
    private String name;

            /**
            * 排序
            */
    private String sort;

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