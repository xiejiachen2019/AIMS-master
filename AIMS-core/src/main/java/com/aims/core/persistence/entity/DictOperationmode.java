package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

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
    public class DictOperationmode implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("Id")
    private Integer Id;

        @TableField("Code")
    private String Code;

        @TableField("Name")
    private String Name;

        @TableField("PriceUnit")
    private String PriceUnit;

        @TableField("Price")
    private BigDecimal Price;

        @TableField("PinYin")
    private String PinYin;

        @TableField("WuBi")
    private String WuBi;


}