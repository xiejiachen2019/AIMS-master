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
    public class MedPatMasterIndex implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("PATIENT_ID")
    private String patientId;

        @TableField("INP_NO")
    private String inpNo;

        @TableField("NAME")
    private String name;

        @TableField("NAME_PHONETIC")
    private String namePhonetic;

        @TableField("SEX")
    private String sex;

        @TableField("DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;

        @TableField("BIRTH_PLACE")
    private String birthPlace;

        @TableField("CITIZENSHIP")
    private String citizenship;

        @TableField("NATION")
    private String nation;

        @TableField("ID_NO")
    private String idNo;

        @TableField("IDENTITY")
    private String identity;

        @TableField("CHARGE_TYPE")
    private String chargeType;

        @TableField("UNIT_IN_CONTRACT")
    private String unitInContract;

        @TableField("MAILING_ADDRESS")
    private String mailingAddress;

        @TableField("ZIP_CODE")
    private String zipCode;

        @TableField("PHONE_NUMBER_HOME")
    private String phoneNumberHome;

        @TableField("PHONE_NUMBER_BUSINESS")
    private String phoneNumberBusiness;

        @TableField("NEXT_OF_KIN")
    private String nextOfKin;

        @TableField("RELATIONSHIP")
    private String relationship;

        @TableField("NEXT_OF_KIN_ADDR")
    private String nextOfKinAddr;

        @TableField("NEXT_OF_KIN_ZIP_CODE")
    private String nextOfKinZipCode;

        @TableField("NEXT_OF_KIN_PHONE")
    private String nextOfKinPhone;

        @TableField("LAST_VISIT_DATE")
    private LocalDateTime lastVisitDate;

        @TableField("VIP_INDICATOR")
    private BigDecimal vipIndicator;

        @TableField("CREATE_DATE")
    private LocalDateTime createDate;

        @TableField("OPERATOR")
    private String operator;


}