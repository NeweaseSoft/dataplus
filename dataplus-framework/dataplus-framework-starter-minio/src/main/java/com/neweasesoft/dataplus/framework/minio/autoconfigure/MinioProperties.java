package com.neweasesoft.dataplus.framework.minio.autoconfigure;

import com.neweasesoft.dataplus.framework.minio.Constants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MinIO 配置属性类
 *
 * @author fushuwei
 */
@Data
@ConfigurationProperties(prefix = Constants.CONFIG_PROPERTIES_PREFIX)
public class MinioProperties {

    /**
     * 是否启用 MinIO, 默认 true
     */
    private Boolean enable = true;

    /**
     * MinIO IP地址
     */
    private String endpoint;

    /**
     * MinIO 端口号, 默认是 9000 (注意: 这里的端口是 API 服务的端口, 不是 Console 服务的端口)
     */
    private Integer port = 9000;

    /**
     * 是否用 HTTPS 访问, 默认否
     */
    private Boolean secure = false;

    /**
     * 账户
     */
    private String accessKey;

    /**
     * 密码
     */
    private String secretKey;

    /**
     * 存储桶的区域
     */
    private String region;

    /**
     * 设置连接超时时间, 单位毫秒, 默认0, 表示没有超时限制
     */
    private Long connectTimeout = 0L;

    /**
     * 设置写入超时时间, 单位毫秒, 默认0, 表示没有超时限制
     */
    private Long writeTimeout = 0L;

    /**
     * 设置读取超时时间, 单位毫秒, 默认0, 表示没有超时限制
     */
    private Long readTimeout = 0L;

    /**
     * 默认存储桶名称, 非必填
     */
    private String bucketName;

    /**
     * 启动时检查桶是否存在, 默认是, 该配置项仅在 bucketName 不为空时有效
     */
    private Boolean checkBucketIsExists = true;

    /**
     * 桶不存在时是否创建, 默认是, 该配置项仅在 bucketName 不为空时有效
     */
    private Boolean createBucketIfNotExists = true;
}
