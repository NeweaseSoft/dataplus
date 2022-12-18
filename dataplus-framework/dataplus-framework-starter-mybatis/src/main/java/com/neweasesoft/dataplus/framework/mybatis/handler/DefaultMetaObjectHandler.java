package com.neweasesoft.dataplus.framework.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.neweasesoft.dataplus.framework.mybatis.base.BaseEntity;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;
import java.util.Objects;

/**
 * 数据持久化时, 公共字段默认的更新机制
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 判断新增对象是否为空, 且类型是否正确
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            // 获取当前操作数据
            BaseEntity<?> baseEntity = (BaseEntity<?>) metaObject.getOriginalObject();

            // 获取当前登录用户的Id
            String userId = null;

            // 如果创建人为空, 则使用当前登录用户的Id填充
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getCreateBy())) {
                baseEntity.setCreateBy(userId);
            }

            // 如果更新人为空, 则使用当前登录用户的Id填充
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getUpdateBy())) {
                baseEntity.setUpdateBy(userId);
            }

            // 获取当前系统时间
            Date date = new Date();

            // 如果创建时间为空, 则使用当前时间填充
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(date);
            }

            // 如果更新时间为空, 则使用当前时间填充
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(date);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 判断更新对象是否为空
        if (Objects.isNull(metaObject)) {
            return;
        }

        // 获取当前登录用户的Id
        String userId = null;

        // 获取当前系统时间
        Date date = new Date();

        if (metaObject.hasGetter("isForceUpdateFill") && (boolean) getFieldValByName("isForceUpdateFill", metaObject)) {
            // 强制更新
            setFieldValByName("updateBy", userId, metaObject);
            setFieldValByName("updateTime", date, metaObject);
        } else {
            // 如果更新人为空, 则使用当前登录用户的Id填充
            Object updateBy = getFieldValByName("updateBy", metaObject);
            if (Objects.nonNull(userId) && Objects.isNull(updateBy)) {
                setFieldValByName("updateBy", userId, metaObject);
            }

            // 如果更新时间为空, 则使用当前时间填充
            Object updateTime = getFieldValByName("updateTime", metaObject);
            if (Objects.isNull(updateTime)) {
                setFieldValByName("updateTime", date, metaObject);
            }
        }
    }
}
