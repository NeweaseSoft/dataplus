package com.neweasesoft.dataplus.module.datasource.controller;

import com.neweasesoft.dataplus.module.datasource.entity.DataSourceType;
import com.neweasesoft.dataplus.module.datasource.service.DataSourceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据源类型 Controller
 */
@RestController
@RequestMapping("/dataSourceType")
public class DataSourceTypeController {

    @Resource
    private DataSourceTypeService dataSourceTypeService;

    @GetMapping("/list")
    public Object list() {
        List<DataSourceType> list = dataSourceTypeService.list();
        return list;
    }
}
