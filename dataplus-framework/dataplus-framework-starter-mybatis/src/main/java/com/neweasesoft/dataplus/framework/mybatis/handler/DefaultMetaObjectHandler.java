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
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            // 获取当前操作数据
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();

            // 获取当前系统时间
            Date current = new Date();

            // 如果创建时间为空, 则使用当前时间填充
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(current);
            }

            // 如果更新时间为空, 则使用当前时间填充
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(current);
            }

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
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果更新时间为空, 则使用当前时间填充
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(updateTime)) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

        // 如果更新人为空, 则使用当前登录用户的Id填充
        Object updateBy = getFieldValByName("updateBy", metaObject);
        String userId = null;
        if (Objects.nonNull(userId) && Objects.isNull(updateBy)) {
            setFieldValByName("updateBy", userId, metaObject);
        }
    }
}
