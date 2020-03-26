package com.aims.ser.controller;


import com.aims.core.persistence.entity.DictFloor;
import com.aims.core.service.IDictFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author XIE JIACHEN
 * @since 2020-03-25
 */
@RestController
@RequestMapping("/dictfloor")
public class DictFloorController {

    @Autowired
    private IDictFloorService iDictFloorService;

    @GetMapping("/list")
    public List<DictFloor> getAllDictFloorList(){

        return iDictFloorService.getAllDictFloorList();
    }

}
