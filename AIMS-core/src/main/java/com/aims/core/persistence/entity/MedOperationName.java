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
    public class MedOperationName implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("PATIENT_ID")
    private String patientId;

        @TableField("VISIT_ID")
    private BigDecimal visitId;

        @TableField("OPER_ID")
    private BigDecimal operId;

        @TableField("OPERATION_NO")
    private BigDecimal operationNo;

        @TableField("OPERATION")
    private String operation;

        @TableField("OPERATION_CODE")
    private String operationCode;

        @TableField("OPERATION_SCALE")
    private String operationScale;

        @TableField("WOUND_GRADE")
    private String woundGrade;

        @TableField("RESERVED1")
    private String reserved1;

        @TableField("RESERVED2")
    private String reserved2;

        @TableField("RESERVED3")
    private String reserved3;

        @TableField("RESERVED4")
    private String reserved4;

        @TableField("RESERVED5")
    private BigDecimal reserved5;


}