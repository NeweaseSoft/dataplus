package com.neweasesoft.dataplus.framework.common.coc.web;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 响应数据封装类
 *
 * @author fushuwei
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应成功结果
     *
     * @param data 返回值
     * @param <T>  泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(Status.OK.code, Status.OK.i18n, data);
    }

    /**
     * 响应成功结果
     *
     * @param message 提示信息
     * @param data    返回值
     * @param <T>     泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(String message, T data) {
        return new Result<>(Status.OK.code, message, data);
    }

    /**
     * 响应失败结果
     *
     * @param data 返回值
     * @param <T>  泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(Status.FAIL.code, Status.FAIL.i18n, data);
    }

    /**
     * 响应失败结果
     *
     * @param message 提示信息
     * @param data    返回值
     * @param <T>     泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(String message, T data) {
        return new Result<>(Status.FAIL.code, message, data);
    }

    /**
     * 响应结果
     *
     * @param status Status对象
     * @param data   返回值
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> back(Status status, T data) {
        return new Result<>(status.code, status.i18n, data);
    }

    /**
     * 响应结果
     *
     * @param code    状态码
     * @param message 提示信息
     * @param data    返回值
     * @param <T>     泛型
     * @return Result对象
     */
    public static <T> Result<T> back(int code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
