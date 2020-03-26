package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
    public class MedHisUsers implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId("USER_ID")
    private String userId;

        @TableField("USER_NAME")
    private String userName;

        @TableField("USER_DEPT")
    private String userDept;

        @TableField("INPUT_CODE")
    private String inputCode;

        @TableField("USER_JOB")
    private String userJob;

        @TableField("RESERVED01")
    private String reserved01;

        @TableField("CREATE_DATE")
    private LocalDateTime createDate;


}