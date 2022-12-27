package com.neweasesoft.dataplus.framework.minio.autoconfigure;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO 自动配置类
 *
 * @author fushuwei
 */
@Slf4j
@AllArgsConstructor
@Configuration
@ConditionalOnClass(MinioClient.class)
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {

    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        // 判断是否启用 MinIO
        if (!minioProperties.getEnable()) {
            return null;
        }

        // 判断参数是否配置
        if (StringUtils.isBlank(minioProperties.getEndpoint())) {
            logger.error("MinioClient initialization failed, because [\"endpoint\"] is null");
            return null;
        }
        if (StringUtils.isBlank(minioProperties.getAccessKey())) {
            logger.error("MinioClient initialization failed, because [\"accessKey\"] is null");
            return null;
        }
        if (StringUtils.isBlank(minioProperties.getSecretKey())) {
            logger.error("MinioClient initialization failed, because [\"secretKey\"] is null");
            return null;
        }

        // 输出 Initializing 日志
        logger.info("Initializing MinioClient [\"{}\"]",
            new HttpUrl.Builder()
                .scheme(minioProperties.getSecure() ? "https" : "http")
                .host(minioProperties.getEndpoint())
                .port(minioProperties.getPort()).build());

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
        minioClient.setTimeout(
            minioProperties.getConnectTimeout(),
            minioProperties.getWriteTimeout(),
            minioProperties.getReadTimeout());

        // 检查桶是否存在
        if (StringUtils.isNotBlank(minioProperties.getBucketName()) && minioProperties.getCheckBucketIsExists()) {
            logger.info("Start to verify whether the bucket [\"{}\"] exists", minioProperties.getBucketName());
            if (!checkBucket(minioClient) && minioProperties.getCreateBucketIfNotExists()) {
                logger.info("The bucket [\"{}\"] is not exist, and creating now", minioProperties.getBucketName());
                createBucket(minioClient);
                logger.info("The bucket [\"{}\"] create success", minioProperties.getBucketName());
            }
        }

        logger.info("MinioClient initialization completed");
        return minioClient;
    }

    /**
     * 校验 Bucket 是否存在
     *
     * @param minioClient Minio连接客户端
     * @return boolean
     */
    private boolean checkBucket(MinioClient minioClient) {
        boolean isExists;
        try {
            isExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
        } catch (Exception e) {
            throw new RuntimeException("Bucket check Failed", e);
        }
        return isExists;
    }

    /**
     * 创建 Bucket
     *
     * @param minioClient Minio连接客户端
     */
    private void createBucket(MinioClient minioClient) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
        } catch (Exception e) {
            throw new RuntimeException("Bucket create Failed", e);
        }
    }
}
