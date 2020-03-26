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
public class DictNurse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Id")
    private Integer Id;

    @TableField("NurseCode")
    private String NurseCode;

    @TableField("NurseName")
    private String NurseName;

    @TableField("SexCode")
    private String SexCode;

    @TableField("SexName")
    private String SexName;

    @TableField("DeptCode")
    private String DeptCode;

    @TableField("DeptName")
    private String DeptName;

    @TableField("ContactPhone")
    private String ContactPhone;

    @TableField("PinYin")
    private String PinYin;

    @TableField("WuBi")
    private String WuBi;

    @TableField("IsDeleted")
    private Integer IsDeleted;


}