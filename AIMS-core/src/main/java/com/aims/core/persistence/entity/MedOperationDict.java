package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    public class MedOperationDict implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("OPERATION_CODE")
    private String operationCode;

            @TableId("OPERATION_NAME")
    private String operationName;

        @TableField("OPERATION_SCALE")
    private String operationScale;

        @TableField("STD_INDICATOR")
    private BigDecimal stdIndicator;

        @TableField("APPROVED_INDICATOR")
    private BigDecimal approvedIndicator;

        @TableField("CREATE_DATE")
    private LocalDateTime createDate;

        @TableField("INPUT_CODE")
    private String inputCode;

        @TableField("INPUT_CODE_WB")
    private String inputCodeWb;


}