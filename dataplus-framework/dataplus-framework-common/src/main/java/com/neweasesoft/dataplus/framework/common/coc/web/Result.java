package com.neweasesoft.dataplus.framework.common.coc.web;

import com.neweasesoft.dataplus.framework.common.i18n.MessageUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Locale;

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
     * 描述信息
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
        return new Result<>(Status.OK.code, MessageUtil.getMessage(Status.OK.i18n, Locale.SIMPLIFIED_CHINESE), data);
    }

    /**
     * 响应成功结果
     *
     * @param message 描述信息
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
     * @param message 描述信息
     * @param data    返回值
     * @param <T>     泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(String message, T data) {
        return new Result<>(Status.FAIL.code, message, data);
    }

    /**
     * 响应自定义结果
     *
     * @param status Status对象
     * @param data   返回值
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> customize(Status status, T data) {
        return new Result<>(status.code, status.i18n, data);
    }

    /**
     * 响应自定义结果
     *
     * @param code    状态码
     * @param message 描述信息
     * @param data    返回值
     * @param <T>     泛型
     * @return Result对象
     */
    public static <T> Result<T> customize(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    /**
     * 返回布尔结果, 基于布尔类型的返回值判断状态码是成功还是失败
     *
     * @param data 返回值
     * @return Result对象
     */
    public static Result<Boolean> retBool(Boolean data) {
        if (data) {
            return ok(true);
        } else {
            return fail(false);
        }
    }

    /**
     * 返回布尔结果, 基于布尔类型的返回值判断状态码是成功还是失败
     *
     * @param message 描述信息
     * @param data    返回值
     * @return Result对象
     */
    public static Result<Boolean> retBool(String message, Boolean data) {
        if (data) {
            return ok(message, true);
        } else {
            return fail(message, false);
        }
    }

    /**
     * 返回布尔结果, 基于布尔类型的返回值判断状态码是成功还是指定状态码
     *
     * @param status Status对象
     * @param data   返回值
     * @return Result对象
     */
    public static Result<Boolean> retBool(Status status, Boolean data) {
        if (data) {
            return ok(status.i18n, true);
        } else {
            return customize(status, false);
        }
    }

    /**
     * 返回布尔结果, 基于布尔类型的返回值判断状态码是成功还是指定状态码
     *
     * @param code    状态码
     * @param message 描述信息
     * @param data    返回值
     * @return Result对象
     */
    public static Result<Boolean> retBool(int code, String message, Boolean data) {
        if (data) {
            return ok(message, true);
        } else {
            return customize(code, message, false);
        }
    }
}
