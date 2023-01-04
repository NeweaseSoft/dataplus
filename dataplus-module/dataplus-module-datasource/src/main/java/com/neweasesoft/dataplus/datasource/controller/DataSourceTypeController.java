package com.neweasesoft.dataplus.datasource.controller;

import com.neweasesoft.dataplus.datasource.entity.DataSourceType;
import com.neweasesoft.dataplus.datasource.service.DataSourceTypeService;
import com.neweasesoft.dataplus.framework.web.coc.Result;
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
     * @return 数据源类型列表
     */
    @GetMapping("/list")
    public Result<List<DataSourceType>> list() {
        return Result.ok(dataSourceTypeService.list());
    }

    /**
     * 保存
     *
     * @return true: 保存成功, false: 保存失败
     */
    @GetMapping("/save")
    public Result<Boolean> save() {
        return Result.retBool(dataSourceTypeService.save(new DataSourceType().setName("张三")));
    }

    /**
     * 更新
     *
     * @param id 数据源类型Id
     * @return true: 保存成功, false: 保存失败
     */
    @GetMapping("/update")
    public Result<Boolean> update(String id) {
        DataSourceType dataSourceType = dataSourceTypeService.getById(id);
        dataSourceType.setName("李四").setRemark("test");
        return Result.retBool(dataSourceTypeService.updateById(dataSourceType));
    }

    /**
     * 删除
     *
     * @param id 数据源类型Id
     * @return true: 保存成功, false: 保存失败
     */
    @GetMapping("/delete")
    public Result<Boolean> delete(String id) {
        return Result.retBool(dataSourceTypeService.removeById(id));
    }
}
