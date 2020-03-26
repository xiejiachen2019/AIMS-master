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
    public class MedOperatingRoom implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("ROOM_NO")
    private String roomNo;

        @TableField("DEPT_CODE")
    private String deptCode;

        @TableField("LOCATION")
    private String location;

        @TableField("STATUS")
    private String status;

        @TableField("BED_ID")
    private BigDecimal bedId;

        @TableField("BED_LABEL")
    private String bedLabel;

        @TableField("MONITOR_CODE")
    private String monitorCode;

        @TableField("BRANCH_NO")
    private BigDecimal branchNo;

        @TableField("SAM_SPACE")
    private BigDecimal samSpace;

        @TableField("PATIENT_ID")
    private String patientId;

        @TableField("VISIT_ID")
    private BigDecimal visitId;

        @TableField("OPER_ID")
    private BigDecimal operId;

        @TableField("BED_TYPE")
    private String bedType;


}