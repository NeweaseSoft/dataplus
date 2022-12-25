package com.neweasesoft.dataplus.framework.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.neweasesoft.dataplus.framework.mybatis.handler.DefaultMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;

/**
 * Mybatis 配置类
 *
 * @author fushuwei
 */
@Configuration
@MapperScan("com.neweasesoft.dataplus.**.mapper")
public class MybatisConfiguration {

    /**
     * 设置 Mybatis-Plus 拦截器, 如: 分页拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 数据持久化时, 公共字段默认的更新机制
     */
    @Bean
    public MetaObjectHandler defaultMetaObjectHandler() {
        return new DefaultMetaObjectHandler();
    }

    /**
     * Mybatis 配置
     */
    @PostConstruct
    public org.apache.ibatis.session.Configuration configuration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(org.apache.ibatis.logging.slf4j.Slf4jImpl.class); // 设置输出SQL日志
        return configuration;
    }

    /**
     * Mybatis Plus 配置
     */
    @Bean
    @Primary
    public MybatisPlusProperties mybatisPlusProperties() {
        MybatisPlusProperties properties = new MybatisPlusProperties();
        properties.getGlobalConfig().setBanner(false); // 设置不输出banner
        return properties;
    }
}
