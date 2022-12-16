package com.neweasesoft.dataplus.framework.profile.config;

import com.neweasesoft.dataplus.framework.profile.core.BannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Banner自动配置类
 */
@Configuration
public class BannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }
}
