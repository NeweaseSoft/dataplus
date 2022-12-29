package com.neweasesoft.dataplus.framework.minio.client;

import com.neweasesoft.dataplus.framework.minio.autoconfigure.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.ListObjectsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import io.minio.Result;
import io.minio.StatObjectArgs;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Optional;

/**
 * MinIO 操作类
 *
 * @author fushuwei
 */
@Slf4j
@AllArgsConstructor
public class MinioTemplate {

    private MinioClient minioClient;

    private MinioProperties minioProperties;

    /**
     * 获取所有桶信息
     *
     * @return 桶信息列表
     */
    public List<Bucket> listBuckets() {
        try {
            return minioClient.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException("获取所有桶信息失败", e);
        }
    }

    /**
     * 获取指定桶信息
     *
     * @param bucketName 桶名称
     * @return 桶信息
     */
    public Optional<Bucket> getBucket(String bucketName) {
        try {
            return minioClient.listBuckets().stream().filter(b -> b.name().equals(bucketName)).findFirst();
        } catch (Exception e) {
            throw new RuntimeException("获取指定桶信息失败", e);
        }
    }

    /**
     * 校验桶是否存在
     *
     * @param bucketName 桶名称
     * @return true 存在, false 不存在
     */
    public boolean bucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException("校验桶是否存在失败", e);
        }
    }

    /**
     * 创建桶
     *
     * @param bucketName 桶名称
     */
    public void createBucket(String bucketName) {
        if (!this.bucketExists(bucketName)) {
            try {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            } catch (Exception e) {
                throw new RuntimeException("创建桶失败", e);
            }
        }
    }

    /**
     * 删除指定的桶
     *
     * @param bucketName 桶名称
     */
    public void removeBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException("删除指定的桶失败", e);
        }
    }

    /**
     * 列出桶中的所有对象 (文件和文件夹)
     *
     * @return Result<Item>
     */
    public Iterable<Result<Item>> listObjects() {
        return listObjects(minioProperties.getBucketName());
    }

    /**
     * 列出桶中的所有对象 (文件和文件夹)
     *
     * @param bucketName 桶名称
     * @return Result<Item>
     */
    public Iterable<Result<Item>> listObjects(String bucketName) {
        return minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).recursive(true).build());
    }

    /**
     * 校验文件夹是否存在
     *
     * @param folderName 文件夹名称
     * @return true 存在, false 不存在
     */
    public boolean folderExists(String folderName) {
        return folderExists(minioProperties.getBucketName(), folderName);
    }

    /**
     * 校验文件夹是否存在
     *
     * @param bucketName 桶名称
     * @param folderName 文件夹名称
     * @return true 存在, false 不存在
     */
    public boolean folderExists(String bucketName, String folderName) {
        if (StringUtils.isBlank(bucketName) || StringUtils.isBlank(folderName)) {
            return false;
        }
        try {
            Iterable<Result<Item>> results = listObjects(bucketName);
            for (Result<Item> result : results) {
                Item item = result.get();
                if (item.isDir() && folderName.equals(item.objectName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("校验文件夹是否存在失败, 详情: {}", e.getMessage());
        }
        return false;
    }

    /**
     * 校验文件是否存在
     *
     * @param fileName 文件名称, 支持包含路径地址的文件名称, 如: /lib/foo.jar
     * @return true 存在, false 不存在
     */
    public boolean fileExists(String fileName) {
        return fileExists(minioProperties.getBucketName(), fileName);
    }

    /**
     * 校验文件是否存在
     *
     * @param bucketName 桶名称
     * @param fileName   文件名称, 支持包含路径地址的文件名称, 如: /lib/foo.jar
     * @return true 存在, false 不存在
     */
    public boolean fileExists(String bucketName, String fileName) {
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(fileName).build());
            return true;
        } catch (Exception e) {
            logger.error("校验文件是否存在失败, 详情: {}", e.getMessage());
        }
        return false;
    }

    /**
     * 获取对象
     *
     * @param objectName 对象名称
     * @return 文件流
     */
    public InputStream getObject(String objectName) {
        return getObject(minioProperties.getBucketName(), objectName);
    }

    /**
     * 获取对象
     *
     * @param bucketName 桶名称
     * @param objectName 对象名称
     * @return 文件流
     */
    public InputStream getObject(String bucketName, String objectName) {
        try {
            return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            throw new RuntimeException("获取对象失败", e);
        }
    }

    /**
     * 获取对象
     *
     * @param url 对象URL
     * @return 文件流
     */
    public InputStream getObjectByUrl(String url) {
        try {
            return new URL(url).openStream();
        } catch (Exception e) {
            throw new RuntimeException("获取对象失败", e);
        }
    }
}
