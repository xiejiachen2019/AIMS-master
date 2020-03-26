package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
    public class MedOperationScaleDict implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("SERIAL_NO")
    private BigDecimal serialNo;

            @TableId("OPERATION_SCALE_CODE")
    private String operationScaleCode;

        @TableField("OPERATION_SCALE_NAME")
    private String operationScaleName;

        @TableField("INPUT_CODE")
    private String inputCode;


}