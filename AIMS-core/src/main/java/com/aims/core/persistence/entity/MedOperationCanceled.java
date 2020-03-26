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
    public class MedOperationCanceled implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("PATIENT_ID")
    private String patientId;

        @TableField("VISIT_ID")
    private BigDecimal visitId;

        @TableField("CANCEL_ID")
    private BigDecimal cancelId;

        @TableField("DEPT_STAYED")
    private String deptStayed;

        @TableField("SCHEDULED_DATE_TIME")
    private LocalDateTime scheduledDateTime;

        @TableField("OPERATING_ROOM")
    private String operatingRoom;

        @TableField("OPERATING_ROOM_NO")
    private String operatingRoomNo;

        @TableField("SEQUENCE")
    private BigDecimal sequence;

        @TableField("DIAG_BEFORE_OPERATION")
    private String diagBeforeOperation;

        @TableField("PATIENT_CONDITION")
    private String patientCondition;

        @TableField("OPERATION_SCALE")
    private String operationScale;

        @TableField("ISOLATION_INDICATOR")
    private BigDecimal isolationIndicator;

        @TableField("OPERATING_DEPT")
    private String operatingDept;

        @TableField("SURGEON")
    private String surgeon;

        @TableField("FIRST_ASSISTANT")
    private String firstAssistant;

        @TableField("SECOND_ASSISTANT")
    private String secondAssistant;

        @TableField("THIRD_ASSISTANT")
    private String thirdAssistant;

        @TableField("FOURTH_ASSISTANT")
    private String fourthAssistant;

        @TableField("ANESTHESIA_METHOD")
    private String anesthesiaMethod;

        @TableField("ANESTHESIA_DOCTOR")
    private String anesthesiaDoctor;

        @TableField("ANESTHESIA_ASSISTANT")
    private String anesthesiaAssistant;

        @TableField("BLOOD_TRAN_DOCTOR")
    private String bloodTranDoctor;

        @TableField("NOTES_ON_OPERATION")
    private String notesOnOperation;

        @TableField("ENTERED_BY")
    private String enteredBy;

        @TableField("CANCEL_REASON")
    private String cancelReason;

        @TableField("RESERVED1")
    private String reserved1;

        @TableField("OPERATION_ID")
    private String operationId;

        @TableField("RESERVED2")
    private String reserved2;

        @TableField("RESERVED3")
    private String reserved3;

        @TableField("RESERVED4")
    private String reserved4;

        @TableField("RESERVED5")
    private String reserved5;

        @TableField("RESERVED6")
    private String reserved6;

        @TableField("RESERVED7")
    private String reserved7;

        @TableField("RESERVED8")
    private String reserved8;

        @TableField("RESERVED9")
    private LocalDateTime reserved9;

        @TableField("RESERVED10")
    private LocalDateTime reserved10;

        @TableField("RESERVED11")
    private BigDecimal reserved11;

        @TableField("RESERVED12")
    private BigDecimal reserved12;

        @TableField("OPER_ID")
    private BigDecimal operId;


}