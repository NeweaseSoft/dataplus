package com.neweasesoft.dataplus.framework.mybatis.autoconfigure;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

/**
 * 数据源配置类
 *
 * @author fushuwei
 */
public class DataSourceAutoConfiguration {

    @Bean
    @Primary
    public DataSourceProperties dataSourceProperties() {
        DataSourceProperties properties = new DataSourceProperties();
        properties.setType(HikariDataSource.class);
        return properties;
    }

    @Bean
    @Primary
    public HikariDataSource hikariDataSource(DataSourceProperties properties) {
        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        dataSource.setMinimumIdle(10);  // 连接池中最小空闲连接数
        dataSource.setMaximumPoolSize(30);  // 连接池中最大连接数
        return dataSource;
    }
}
