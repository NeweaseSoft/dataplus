package com.neweasesoft.dataplus.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neweasesoft.dataplus.datasource.mapper.DataSourceTypeMapper;
import com.neweasesoft.dataplus.datasource.entity.DataSourceType;
import com.neweasesoft.dataplus.datasource.service.DataSourceTypeService;
import org.springframework.stereotype.Service;

/**
 * 数据源类型 ServiceImpl
 *
 * @author fushuwei
 */
@Service
public class DataSourceTypeServiceImpl extends ServiceImpl<DataSourceTypeMapper, DataSourceType> implements DataSourceTypeService {
}
