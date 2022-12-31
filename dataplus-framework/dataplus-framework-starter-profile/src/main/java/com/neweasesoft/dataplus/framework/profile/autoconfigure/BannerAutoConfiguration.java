package com.neweasesoft.dataplus.framework.profile.autoconfigure;

import com.neweasesoft.dataplus.framework.profile.runner.BannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Banner自动配置类
 *
 * @author fushuwei
 */
@Configuration
public class BannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }
}
