package com.aims.core.util;

import lombok.extern.slf4j.Slf4j;

/**
 * 这里对雪花算法根据业务需求做了定制：对本系统来说，不需要很多机房，所以那5个bit用做机房id可能意义不是太大，
 * 因此将机房id用busId代替，busId可以代表每一个表的唯一标识，同时机器ID也不需要很多，降低机器ID的位数，增加busId
 * 的位数。
 */
@Slf4j
public class SnowflakeBusiIdWorker extends SnowflakeIdWorker {
  // 机器ID所占位数
  private static final long ID_BITS = 4L;
  // 数据中心ID所占位数
  private static final long DATA_CENTER_ID_BITS = 7L;

  /**
   * 构造
   *
   * @param workerId 机器ID(0-15)：支持16台机器
   * @param dataCenterId 数据中心ID(0-127)：支持128张表
   */
  public SnowflakeBusiIdWorker(long workerId, long dataCenterId) {
    super(workerId, dataCenterId);
    super.ID_BITS = ID_BITS;
    super.DATA_CENTER_ID_BITS = DATA_CENTER_ID_BITS;
  }
}
