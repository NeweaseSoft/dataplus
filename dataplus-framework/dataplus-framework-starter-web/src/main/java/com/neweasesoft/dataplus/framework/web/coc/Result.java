package com.neweasesoft.dataplus.framework.web.coc;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 响应结果封装类
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
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 响应自定义结果
     *
     * @param data   返回数据
     * @param status Status对象
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> get(T data, Status status) {
        return new Result<>(status.getCode(), status.getMessage(), data);
    }

    /**
     * 响应自定义结果
     *
     * @param data   返回数据
     * @param status Status对象
     * @param args   参数
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> get(T data, Status status, Object[] args) {
        return new Result<>(status.getCode(), status.getMessage(args), data);
    }

    /**
     * 响应自定义结果
     *
     * @param data    返回数据
     * @param code    状态码
     * @param message 返回消息
     * @param <T>     泛型
     * @return Result对象
     */
    public static <T> Result<T> get(T data, int code, String message) {
        return new Result<>(code, message, data);
    }

    /**
     * 响应成功结果
     *
     * @param data 返回数据
     * @param <T>  泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(Status.OK.getCode(), Status.OK.getMessage(), data);
    }

    /**
     * 响应成功结果
     *
     * @param data   返回数据
     * @param status Status对象
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(T data, Status status) {
        return new Result<>(status.getCode(), status.getMessage(), data);
    }

    /**
     * 响应成功结果
     *
     * @param data   返回数据
     * @param status Status对象
     * @param args   参数
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(T data, Status status, Object[] args) {
        return new Result<>(status.getCode(), status.getMessage(args), data);
    }

    /**
     * 响应失败结果
     *
     * @param data 返回数据
     * @param <T>  泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(Status.FAIL.getCode(), Status.FAIL.getMessage(), data);
    }

    /**
     * 响应失败结果
     *
     * @param data   返回数据
     * @param status Status对象
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data, Status status) {
        return new Result<>(status.getCode(), status.getMessage(), data);
    }

    /**
     * 响应失败结果
     *
     * @param data   返回数据
     * @param status Status对象
     * @param args   参数
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data, Status status, Object[] args) {
        return new Result<>(status.getCode(), status.getMessage(args), data);
    }

    /**
     * 返回布尔结果
     *
     * @param data       返回数据
     * @param okStatus   成功状态码
     * @param failStatus 失败状态码
     * @return Result对象
     */
    public static Result<Boolean> retBool(Boolean data, Status okStatus, Status failStatus) {
        if (data) {
            return Result.ok(true, okStatus);
        } else {
            return Result.fail(false, failStatus);
        }
    }

    /**
     * 返回布尔结果
     *
     * @param data       返回数据
     * @param okStatus   成功状态码
     * @param okArgs     参数
     * @param failStatus 失败状态码
     * @param failArgs   参数
     * @return Result对象
     */
    public static Result<Boolean> retBool(Boolean data, Status okStatus, Object[] okArgs, Status failStatus, Object[] failArgs) {
        if (data) {
            return Result.ok(true, okStatus, okArgs);
        } else {
            return Result.fail(false, failStatus, failArgs);
        }
    }
}
