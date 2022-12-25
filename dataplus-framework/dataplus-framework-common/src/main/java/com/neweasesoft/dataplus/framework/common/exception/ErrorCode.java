package com.neweasesoft.dataplus.framework.common.exception;

/**
 * 错误代码接口
 *
 * @author fushuwei
 */
public interface ErrorCode {

    /**
     * 获取错误代码
     *
     * @return
     */
    String getCode();

    /**
     * 获取错误描述
     *
     * @return
     */
    String getDescription();

    /**
     * 必须重写 toString 方法
     *
     * @return
     */
    String toString();
}
