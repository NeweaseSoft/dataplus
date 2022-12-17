package com.neweasesoft.dataplus.module.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neweasesoft.dataplus.module.datasource.entity.DataSourceType;
import com.neweasesoft.dataplus.module.datasource.mapper.DataSourceTypeMapper;
import com.neweasesoft.dataplus.module.datasource.service.DataSourceTypeService;
import org.springframework.stereotype.Service;

@Service
public class DataSourceTypeServiceImpl extends ServiceImpl<DataSourceTypeMapper, DataSourceType> implements DataSourceTypeService {
}
