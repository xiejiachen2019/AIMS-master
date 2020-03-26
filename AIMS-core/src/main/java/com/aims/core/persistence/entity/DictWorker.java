package com.aims.core.persistence.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class DictWorker implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Id")
    private Integer Id;

    @TableField("FloorCode")
    private String FloorCode;

    @TableField("WorkerCode")
    private String WorkerCode;

    @TableField("Worker")
    private String Worker;


}