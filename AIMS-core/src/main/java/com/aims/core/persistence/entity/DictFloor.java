package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author XIE JIACHEN
 * @since 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictFloor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Id")
    private Integer Id;

    @TableField("FloorNo")
    private String FloorNo;

    @TableField("FloorEmpNo")
    private String FloorEmpNo;

    @TableField("FloorName")
    private String FloorName;

    @TableField("IsDelete")
    private Integer IsDelete;


}