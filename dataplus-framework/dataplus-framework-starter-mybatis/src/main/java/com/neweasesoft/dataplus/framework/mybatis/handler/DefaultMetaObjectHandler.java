package com.neweasesoft.dataplus.framework.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 数据持久化时，默认参数填充方式
 *
 * 如果没有显式的对通用参数进行赋值，这里会对通用参数进行填充、赋值
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
