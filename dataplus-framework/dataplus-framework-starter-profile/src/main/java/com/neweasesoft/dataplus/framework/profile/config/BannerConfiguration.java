package com.neweasesoft.dataplus.framework.profile.config;

import com.neweasesoft.dataplus.framework.profile.core.BannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Banner自动配置类
 *
 * @author fushuwei
 */
@Configuration
public class BannerConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }
}
