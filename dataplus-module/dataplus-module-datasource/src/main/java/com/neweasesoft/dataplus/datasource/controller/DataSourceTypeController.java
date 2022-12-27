package com.neweasesoft.dataplus.datasource.controller;

import com.neweasesoft.dataplus.datasource.entity.DataSourceType;
import com.neweasesoft.dataplus.datasource.service.DataSourceTypeService;
import com.neweasesoft.dataplus.framework.common.coc.web.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据源类型 Controller
 *
 * @author fushuwei
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/dataSourceType")
public class DataSourceTypeController {

    private DataSourceTypeService dataSourceTypeService;

    /**
     * 查询列表
     *
     * @return
     */
    @GetMapping("/list")
    public Object list() {
        List<DataSourceType> list = dataSourceTypeService.list();
        return list;
    }

    /**
     * 查询列表, 分页
     *
     * @return
     */
    @GetMapping("/listByPage")
    public Result<String> listByPage() {
        if (1 == 2) {
            return Result.ok(2, "bbc", null);
        }
        return Result.ok(1, "abc", "001");
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
