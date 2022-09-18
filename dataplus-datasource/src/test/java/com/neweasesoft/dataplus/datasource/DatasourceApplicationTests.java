package com.neweasesoft.dataplus.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DatasourceApplicationTests {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /* @RestController
    public class TestController {

        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("/test")
        public String test() {
            return restTemplate.getForObject("http://service-provider/test", String.class);
        }
    } */

}
