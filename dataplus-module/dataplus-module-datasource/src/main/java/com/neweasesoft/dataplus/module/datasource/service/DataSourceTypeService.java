package com.neweasesoft.dataplus.module.datasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neweasesoft.dataplus.module.datasource.entity.DataSourceType;

import java.util.List;

public interface DataSourceTypeService extends IService<DataSourceType> {

    List<DataSourceType> selectList();
}
