package com.aims.core.persistence.mapper;

import com.aims.core.persistence.entity.DictFloor;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author XIE JIACHEN
 * @since 2020-03-25
 */
@Mapper
@Repository
public interface DictFloorMapper extends BaseMapper<DictFloor> {

    List<DictFloor> getAllDictFloor();
}
