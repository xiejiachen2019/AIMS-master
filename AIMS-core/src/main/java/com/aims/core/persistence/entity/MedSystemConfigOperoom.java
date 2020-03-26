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
    public class MedSystemConfigOperoom implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("ROOM_NO")
    private String roomNo;

        @TableField("MAX_OPERATION_COUNT")
    private BigDecimal maxOperationCount;

        @TableField("DEPT_CODE")
    private String deptCode;


}