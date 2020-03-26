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
    public class MedPatVisit implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("PATIENT_ID")
    private String patientId;

        @TableField("VISIT_ID")
    private BigDecimal visitId;

        @TableField("DEPT_ADMISSION_TO")
    private String deptAdmissionTo;

        @TableField("ADMISSION_DATE_TIME")
    private LocalDateTime admissionDateTime;

        @TableField("DEPT_DISCHARGE_FROM")
    private String deptDischargeFrom;

        @TableField("DISCHARGE_DATE_TIME")
    private LocalDateTime dischargeDateTime;

        @TableField("OCCUPATION")
    private String occupation;

        @TableField("MARITAL_STATUS")
    private String maritalStatus;

        @TableField("IDENTITY")
    private String identity;

        @TableField("ARMED_SERVICES")
    private String armedServices;

        @TableField("DUTY")
    private String duty;

        @TableField("TOP_UNIT")
    private String topUnit;

        @TableField("SERVICE_SYSTEM_INDICATOR")
    private BigDecimal serviceSystemIndicator;

        @TableField("UNIT_IN_CONTRACT")
    private String unitInContract;

        @TableField("CHARGE_TYPE")
    private String chargeType;

        @TableField("WORKING_STATUS")
    private BigDecimal workingStatus;

        @TableField("INSURANCE_TYPE")
    private String insuranceType;

        @TableField("INSURANCE_NO")
    private String insuranceNo;

        @TableField("SERVICE_AGENCY")
    private String serviceAgency;

        @TableField("MAILING_ADDRESS")
    private String mailingAddress;

        @TableField("ZIP_CODE")
    private String zipCode;

        @TableField("NEXT_OF_KIN")
    private String nextOfKin;

        @TableField("RELATIONSHIP")
    private String relationship;

        @TableField("NEXT_OF_KIN_ADDR")
    private String nextOfKinAddr;

        @TableField("NEXT_OF_KIN_ZIPCODE")
    private String nextOfKinZipcode;

        @TableField("NEXT_OF_KIN_PHONE")
    private String nextOfKinPhone;

        @TableField("PATIENT_CLASS")
    private String patientClass;

        @TableField("ADMISSION_CAUSE")
    private String admissionCause;

        @TableField("CONSULTING_DATE")
    private LocalDateTime consultingDate;

        @TableField("PAT_ADM_CONDITION")
    private String patAdmCondition;

        @TableField("CONSULTING_DOCTOR")
    private String consultingDoctor;

        @TableField("ADMITTED_BY")
    private String admittedBy;

        @TableField("EMER_TREAT_TIMES")
    private BigDecimal emerTreatTimes;

        @TableField("ESC_EMER_TIMES")
    private BigDecimal escEmerTimes;

        @TableField("SERIOUS_COND_DAYS")
    private BigDecimal seriousCondDays;

        @TableField("CRITICAL_COND_DAYS")
    private BigDecimal criticalCondDays;

        @TableField("ICU_DAYS")
    private BigDecimal icuDays;

        @TableField("CCU_DAYS")
    private BigDecimal ccuDays;

        @TableField("SPEC_LEVEL_NURS_DAYS")
    private BigDecimal specLevelNursDays;

        @TableField("FIRST_LEVEL_NURS_DAYS")
    private BigDecimal firstLevelNursDays;

        @TableField("SECOND_LEVEL_NURS_DAYS")
    private BigDecimal secondLevelNursDays;

        @TableField("AUTOPSY_INDICATOR")
    private BigDecimal autopsyIndicator;

        @TableField("BLOOD_TYPE")
    private String bloodType;

        @TableField("BLOOD_TYPE_RH")
    private String bloodTypeRh;

        @TableField("INFUSION_REACT_TIMES")
    private BigDecimal infusionReactTimes;

        @TableField("BLOOD_TRAN_TIMES")
    private BigDecimal bloodTranTimes;

        @TableField("BLOOD_TRAN_VOL")
    private BigDecimal bloodTranVol;

        @TableField("BLOOD_TRAN_REACT_TIMES")
    private BigDecimal bloodTranReactTimes;

        @TableField("DECUBITAL_ULCER_TIMES")
    private BigDecimal decubitalUlcerTimes;

        @TableField("ALERGY_DRUGS")
    private String alergyDrugs;

        @TableField("ADVERSE_REACTION_DRUGS")
    private String adverseReactionDrugs;

        @TableField("MR_VALUE")
    private String mrValue;

        @TableField("MR_QUALITY")
    private String mrQuality;

        @TableField("FOLLOW_INDICATOR")
    private BigDecimal followIndicator;

        @TableField("FOLLOW_INTERVAL")
    private BigDecimal followInterval;

        @TableField("FOLLOW_INTERVAL_UNITS")
    private String followIntervalUnits;

        @TableField("DIRECTOR")
    private String director;

        @TableField("ATTENDING_DOCTOR")
    private String attendingDoctor;

        @TableField("DOCTOR_IN_CHARGE")
    private String doctorInCharge;

        @TableField("DISCHARGE_DISPOSITION")
    private String dischargeDisposition;

        @TableField("TOTAL_COSTS")
    private BigDecimal totalCosts;

        @TableField("TOTAL_PAYMENTS")
    private BigDecimal totalPayments;

        @TableField("CATALOG_DATE")
    private LocalDateTime catalogDate;

        @TableField("CATALOGER")
    private String cataloger;

        @TableField("RESERVED01")
    private String reserved01;

        @TableField("RESERVED02")
    private String reserved02;

        @TableField("RESERVED03")
    private String reserved03;

        @TableField("RESERVED04")
    private String reserved04;

        @TableField("RESERVED05")
    private String reserved05;

        @TableField("RESERVED06")
    private String reserved06;

        @TableField("RESERVED07")
    private String reserved07;

        @TableField("RESERVED08")
    private String reserved08;

        @TableField("RESERVED09")
    private String reserved09;

        @TableField("RESERVED10")
    private String reserved10;

        @TableField("RESERVED_DATE01")
    private LocalDateTime reservedDate01;

        @TableField("RESERVED_DATE02")
    private LocalDateTime reservedDate02;

        @TableField("BODY_HEIGHT")
    private BigDecimal bodyHeight;

        @TableField("BODY_WEIGHT")
    private BigDecimal bodyWeight;

        @TableField("PATIENT_CONDITION")
    private String patientCondition;

        @TableField("ABNORMAL")
    private String abnormal;


}