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
    public class MedOperationMaster implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("PATIENT_ID")
    private String patientId;

        @TableField("VISIT_ID")
    private BigDecimal visitId;

        @TableField("OPER_ID")
    private BigDecimal operId;

        @TableField("DEPT_STAYED")
    private String deptStayed;

        @TableField("OPERATING_ROOM")
    private String operatingRoom;

        @TableField("OPERATING_ROOM_NO")
    private String operatingRoomNo;

        @TableField("DIAG_BEFORE_OPERATION")
    private String diagBeforeOperation;

        @TableField("PATIENT_CONDITION")
    private String patientCondition;

        @TableField("OPERATION_SCALE")
    private String operationScale;

        @TableField("DIAG_AFTER_OPERATION")
    private String diagAfterOperation;

        @TableField("EMERGENCY_INDICATOR")
    private BigDecimal emergencyIndicator;

        @TableField("ISOLATION_INDICATOR")
    private BigDecimal isolationIndicator;

        @TableField("OPERATION_CLASS")
    private String operationClass;

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

        @TableField("FIRST_OPERATION_NURSE")
    private String firstOperationNurse;

        @TableField("SECOND_OPERATION_NURSE")
    private String secondOperationNurse;

        @TableField("FIRST_SUPPLY_NURSE")
    private String firstSupplyNurse;

        @TableField("SECOND_SUPPLY_NURSE")
    private String secondSupplyNurse;

        @TableField("NURSE_SHIFT_INDICATOR")
    private BigDecimal nurseShiftIndicator;

        @TableField("START_DATE_TIME")
    private LocalDateTime startDateTime;

        @TableField("END_DATE_TIME")
    private LocalDateTime endDateTime;

        @TableField("SATISFACTION_DEGREE")
    private BigDecimal satisfactionDegree;

        @TableField("SMOOTH_INDICATOR")
    private BigDecimal smoothIndicator;

        @TableField("IN_FLUIDS_AMOUNT")
    private BigDecimal inFluidsAmount;

        @TableField("OUT_FLUIDS_AMOUNT")
    private BigDecimal outFluidsAmount;

        @TableField("BLOOD_LOSSED")
    private BigDecimal bloodLossed;

        @TableField("BLOOD_TRANSFERED")
    private BigDecimal bloodTransfered;

        @TableField("ENTERED_BY")
    private String enteredBy;

        @TableField("THIRD_SUPPLY_NURSE")
    private String thirdSupplyNurse;

        @TableField("ORDER_TRANSFER")
    private BigDecimal orderTransfer;

        @TableField("CHARGE_TRANSFER")
    private BigDecimal chargeTransfer;

        @TableField("END_INDICATOR")
    private BigDecimal endIndicator;

        @TableField("RECK_GROUP")
    private String reckGroup;

        @TableField("OPER_STATUS")
    private BigDecimal operStatus;

        @TableField("SECOND_ANESTHESIA_ASSISTANT")
    private String secondAnesthesiaAssistant;

        @TableField("THIRD_ANESTHESIA_ASSISTANT")
    private String thirdAnesthesiaAssistant;

        @TableField("FOURTH_ANESTHESIA_ASSISTANT")
    private String fourthAnesthesiaAssistant;

        @TableField("OPERATION_POSITION")
    private String operationPosition;

        @TableField("OPERATION_EQUIP_INDICATOR")
    private BigDecimal operationEquipIndicator;

        @TableField("SECOND_ANESTHESIA_DOCTOR")
    private String secondAnesthesiaDoctor;

        @TableField("THIRD_ANESTHESIA_DOCTOR")
    private String thirdAnesthesiaDoctor;

        @TableField("OTHER_IN_AMOUNT")
    private BigDecimal otherInAmount;

        @TableField("OTHER_OUT_AMOUNT")
    private BigDecimal otherOutAmount;

        @TableField("IN_DATE_TIME")
    private LocalDateTime inDateTime;

        @TableField("OUT_DATE_TIME")
    private LocalDateTime outDateTime;

        @TableField("RESERVED1")
    private String reserved1;

        @TableField("BLOOD_WHOLE_SELF")
    private BigDecimal bloodWholeSelf;

        @TableField("BLOOD_WHOLE")
    private BigDecimal bloodWhole;

        @TableField("BLOOD_RBC")
    private BigDecimal bloodRbc;

        @TableField("BLOOD_PLASM")
    private BigDecimal bloodPlasm;

        @TableField("BLOOD_OTHER")
    private BigDecimal bloodOther;

        @TableField("RESERVED2")
    private String reserved2;

        @TableField("SPECIAL_EQUIPMENT")
    private String specialEquipment;

        @TableField("SPECIAL_INFECT")
    private String specialInfect;

        @TableField("HEPATITIS_INDICATOR")
    private BigDecimal hepatitisIndicator;

        @TableField("ANES_START_DATE_TIME")
    private LocalDateTime anesStartDateTime;

        @TableField("RETURN_DATE_TIME")
    private LocalDateTime returnDateTime;

        @TableField("SEQUENCE")
    private BigDecimal sequence;

        @TableField("IN_PACU_DATE_TIME")
    private LocalDateTime inPacuDateTime;

        @TableField("OUT_PACU_DATE_TIME")
    private LocalDateTime outPacuDateTime;

        @TableField("OPERATION_ID")
    private String operationId;

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

        @TableField("BLOOD_REUSE")
    private BigDecimal bloodReuse;

        @TableField("SELF_BLOOD")
    private BigDecimal selfBlood;

        @TableField("ENTERED_DATETIME")
    private LocalDateTime enteredDatetime;

        @TableField("MEMO")
    private String memo;

        @TableField("ANESTHESIA_ID")
    private String anesthesiaId;

        @TableField("XJ")
    private BigDecimal xj;

        @TableField("AI")
    private BigDecimal ai;

        @TableField("AT")
    private BigDecimal at;

        @TableField("JT")
    private BigDecimal jt;

        @TableField("BODY_AREA")
    private String bodyArea;

        @TableField("GAS_PIPE")
    private String gasPipe;

        @TableField("PAT_LEAVE_SHOW")
    private String patLeaveShow;

        @TableField("WHOLE_ANES")
    private String wholeAnes;

        @TableField("STOP_ANES_AREA")
    private String stopAnesArea;

        @TableField("STOP_ANES_AREA_MED")
    private String stopAnesAreaMed;

        @TableField("HOLE_PIPLE_ANES")
    private String holePipleAnes;

        @TableField("STOP_ANES_AREA_TECH")
    private String stopAnesAreaTech;

        @TableField("PIN_SIZE")
    private String pinSize;

        @TableField("PIPLE_UP")
    private String pipleUp;

        @TableField("PIPLE_DOWN")
    private String pipleDown;

        @TableField("IRRITATE_NERVE")
    private String irritateNerve;

        @TableField("ANES_RANGE")
    private String anesRange;

        @TableField("BAK_MED")
    private String bakMed;

        @TableField("WATCH_ANES")
    private String watchAnes;

        @TableField("ALL_ANES_MED_LEAD1")
    private String allAnesMedLead1;

        @TableField("ALL_ANES_MED_LEAD2")
    private String allAnesMedLead2;

        @TableField("ALL_ANES_MED_KEEP1")
    private String allAnesMedKeep1;

        @TableField("ALL_ANES_MED_KEEP2")
    private String allAnesMedKeep2;

        @TableField("CHEST_WATER")
    private String chestWater;

        @TableField("ABDOMEN_WATER")
    private String abdomenWater;

        @TableField("INQUIRY_BEFORE_DATE")
    private LocalDateTime inquiryBeforeDate;

        @TableField("INQUIRY_AFTER_DATE")
    private LocalDateTime inquiryAfterDate;

        @TableField("THIRD_OPERATION_NURSE")
    private String thirdOperationNurse;

        @TableField("PACU_DOCTOR")
    private String pacuDoctor;

        @TableField("WATER_JT1")
    private BigDecimal waterJt1;

        @TableField("WATER_JT2")
    private BigDecimal waterJt2;

        @TableField("BLOOD_XB")
    private BigDecimal bloodXb;

        @TableField("COOL_THING")
    private BigDecimal coolThing;

        @TableField("CRY_WATHER")
    private BigDecimal cryWather;

        @TableField("RED_BLOOD")
    private BigDecimal redBlood;

        @TableField("BLOOD_AMOUNT")
    private BigDecimal bloodAmount;

        @TableField("SCHEDULED_DATE_TIME")
    private LocalDateTime scheduledDateTime;

        @TableField("BED_NO")
    private String bedNo;

        @TableField("REQ_DATE_TIME")
    private LocalDateTime reqDateTime;

        @TableField("QIEKOU_CLASS")
    private String qiekouClass;

        @TableField("QIEKOU_NUMBER")
    private BigDecimal qiekouNumber;

        @TableField("MEMO1")
    private String memo1;

        @TableField("OPERATION_NAME")
    private String operationName;

        @TableField("MEN_ZHEN")
    private String menZhen;

        @TableField("ANESTHESIA_RESULT")
    private String anesthesiaResult;

        @TableField("SIMPLE_SICK")
    private String simpleSick;

        @TableField("ISOLATION_NEED")
    private String isolationNeed;

        @TableField("DANBINGZHONG")
    private String danbingzhong;

        @TableField("YIBAO")
    private String yibao;

        @TableField("FIRST_SHIFT_SUPPLY_NURSE")
    private String firstShiftSupplyNurse;

        @TableField("FIRST_SHIFT_OPERATION_NURSE")
    private String firstShiftOperationNurse;

        @TableField("FIRST_SHIFT_SUPPLY_DATETIME")
    private LocalDateTime firstShiftSupplyDatetime;

        @TableField("FIRST_SHIFT_OPERATION_DATETIME")
    private LocalDateTime firstShiftOperationDatetime;

        @TableField("ANES_START_TIME")
    private LocalDateTime anesStartTime;

        @TableField("ANES_END_TIME")
    private LocalDateTime anesEndTime;

        @TableField("INDUCE_START_TIME")
    private LocalDateTime induceStartTime;

        @TableField("INDUCE_END_TIME")
    private LocalDateTime induceEndTime;

        @TableField("PACU_START_TIME")
    private LocalDateTime pacuStartTime;

        @TableField("PACU_END_TIME")
    private LocalDateTime pacuEndTime;

        @TableField("DONE_DATE_TIME")
    private LocalDateTime doneDateTime;

        @TableField("CANCEL_DATE_TIME")
    private LocalDateTime cancelDateTime;

        @TableField("ANALGESIC_PUMPS")
    private String analgesicPumps;


}