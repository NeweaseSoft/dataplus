package com.neweasesoft.dataplus.datasource.controller;

import com.neweasesoft.dataplus.datasource.entity.DataSourceType;
import com.neweasesoft.dataplus.datasource.service.DataSourceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据源类型 Controller
 *
 * @author fushuwei
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

    @GetMapping("/save")
    public boolean save() {
        return dataSourceTypeService.save((DataSourceType) new DataSourceType().setName("张三").setRemark("test"));
    }

    @GetMapping("/update")
    public boolean update(String id) {
        DataSourceType dataSourceType = dataSourceTypeService.getById(id);
        dataSourceType.setName("李四").setRemark("test");
        return dataSourceTypeService.updateById(dataSourceType);
    }

    @GetMapping("/delete")
    public boolean delete(String id) {
        return dataSourceTypeService.removeById(id);
    }
}
