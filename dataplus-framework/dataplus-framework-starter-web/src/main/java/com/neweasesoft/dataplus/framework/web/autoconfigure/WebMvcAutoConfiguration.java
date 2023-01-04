package com.neweasesoft.dataplus.framework.web.autoconfigure;

import com.neweasesoft.dataplus.framework.web.interceptor.LocaleChangeHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc自动配置类
 *
 * @author fushuwei
 */
@Configuration
public class WebMvcAutoConfiguration {

    /**
     * WebMvc配置
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 配置拦截器
             *
             * @param registry 拦截器注册表
             */
            @Override
            public void addInterceptors(@NonNull InterceptorRegistry registry) {
                registry.addInterceptor(new LocaleChangeHandlerInterceptor());
            }
        };
    }
}
