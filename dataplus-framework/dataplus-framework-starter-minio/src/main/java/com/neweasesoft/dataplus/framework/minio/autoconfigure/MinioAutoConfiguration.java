package com.neweasesoft.dataplus.framework.minio.autoconfigure;

import io.minio.MinioClient;
import io.minio.http.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO 配置类
 *
 * @author fushuwei
 */
@Slf4j
@Configuration
@ConditionalOnClass(MinioClient.class)
public class MinioAutoConfiguration {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        // 判断是否启用 MinIO
        if (!minioProperties.getEnable()) {
            return null;
        }

        // 判断参数是否配置
        if (StringUtils.isBlank(minioProperties.getEndpoint())) {
            logger.error("MinioClient initialization failed, because [\"{}\"] is null", minioProperties.getEndpoint());
            return null;
        }
        if (StringUtils.isBlank(minioProperties.getAccessKey())) {
            logger.error("MinioClient initialization failed, because [\"{}\"] is null", minioProperties.getAccessKey());
            return null;
        }
        if (StringUtils.isBlank(minioProperties.getSecretKey())) {
            logger.error("MinioClient initialization failed, because [\"{}\"] is null", minioProperties.getSecretKey());
            return null;
        }

        HttpUrl a = new HttpUrl.Builder().scheme(minioProperties.getSecure() ? "https" : "http").host(minioProperties.getEndpoint()).port(minioProperties.getPort()).build();

        HttpUrl url = HttpUtils.getBaseUrl(minioProperties.getEndpoint());
        url = url.newBuilder().port(minioProperties.getPort()).scheme(minioProperties.getSecure() ? "https" : "http").build();

        logger.info("Initializing MinioClient [\"{}\"]", a);
        logger.info("Initializing MinioClient [\"{}\"]", url);

        // 创建 MinioClient 构造器实例
        MinioClient.Builder minioClientBuilder = MinioClient.builder()
            .endpoint(minioProperties.getEndpoint(), minioProperties.getPort(), minioProperties.getSecure())
            .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey());

        // 判断是否配置 region 参数
        if (StringUtils.isNotBlank(minioProperties.getRegion())) {
            minioClientBuilder.region(minioProperties.getRegion());
        }

        // 创建 MinioClient 实例
        MinioClient minioClient = minioClientBuilder.build();

        // 设置超时时间
        minioClient.setTimeout(minioProperties.getConnectTimeout(), minioProperties.getWriteTimeout(), minioProperties.getReadTimeout());

        return minioClient;
    }
}
