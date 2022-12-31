package com.neweasesoft.dataplus.framework.mybatis.autoconfigure;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.neweasesoft.dataplus.framework.mybatis.handler.DefaultMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Mybatis 配置类
 *
 * @author fushuwei
 */
@Configuration
@MapperScan("com.neweasesoft.dataplus.**.mapper")
public class MybatisAutoConfiguration {

    /**
     * 全局 Mybatis 配置
     */
    @Bean
    @Primary
    public MybatisProperties mybatisProperties() {
        MybatisProperties properties = new MybatisProperties();
        properties.getConfiguration().setLogImpl(org.apache.ibatis.logging.slf4j.Slf4jImpl.class); // 设置输出SQL日志
        return properties;
    }

    /**
     * 全局 Mybatis Plus 配置
     */
    @Bean
    @Primary
    public MybatisPlusProperties mybatisPlusProperties() {
        MybatisPlusProperties properties = new MybatisPlusProperties();
        properties.getGlobalConfig().setBanner(false); // 设置不输出banner
        return properties;
    }

    /**
     * 配置插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 分页插件
        return interceptor;
    }

    /**
     * 数据持久化时, 公共字段默认的更新机制
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new DefaultMetaObjectHandler();
    }
}
