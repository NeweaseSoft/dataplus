package com.neweasesoft.dataplus.module.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.neweasesoft.dataplus.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 数据源类型 Entity
 */
@Getter
@Setter
@TableName("data_source_type")
public class DataSourceType extends BaseEntity {

    private String id;
    private String name;
}
