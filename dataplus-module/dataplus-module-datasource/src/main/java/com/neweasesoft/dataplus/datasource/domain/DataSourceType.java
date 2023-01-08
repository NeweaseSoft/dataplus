package com.neweasesoft.dataplus.datasource.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.neweasesoft.dataplus.framework.mybatis.base.BaseModel;
import lombok.Data;

/**
 * 数据源类型
 *
 * @author fushuwei
 */
@Data
@TableName("data_source_type")
public class DataSourceType extends BaseModel<DataSourceType> {

    private String name;
}
