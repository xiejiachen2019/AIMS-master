package com.aims.core.service.impl;

import com.aims.core.persistence.entity.DictFloor;
import com.aims.core.persistence.mapper.DictFloorMapper;
import com.aims.core.service.IDictFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XIE JIACHEN
 * @since 2020-03-25
 */
@Service
public class DictFloorServiceImpl implements IDictFloorService {

    @Autowired
    private DictFloorMapper dictFloorMapper;

    @Override
    public List<DictFloor> getAllDictFloorList() {
        return dictFloorMapper.getAllDictFloor();
    }
}
