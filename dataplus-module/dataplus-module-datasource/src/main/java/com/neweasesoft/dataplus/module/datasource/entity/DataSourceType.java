package com.neweasesoft.dataplus.module.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.neweasesoft.dataplus.framework.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * 数据源类型 Entity
 */
@Data
@TableName("data_source_type")
public class DataSourceType extends BaseEntity<DataSourceType> {

    private String name;
}
