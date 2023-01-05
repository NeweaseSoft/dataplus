package com.neweasesoft.dataplus.framework.web.coc;

import com.neweasesoft.dataplus.framework.web.i18n.MessageUtils;
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
        return new Result<>(Status.OK.code, Status.OK.getMessage(), data);
    }

    /**
     * 响应成功结果
     *
     * @param data          返回值
     * @param codeOrMessage 描述信息
     * @param <T>           泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(T data, String codeOrMessage) {
        return new Result<>(Status.OK.code, MessageUtils.getMessage(codeOrMessage, codeOrMessage), data);
    }

    /**
     * 响应成功结果
     *
     * @param data          返回值
     * @param codeOrMessage 描述信息
     * @param args          参数
     * @param <T>           泛型
     * @return Result对象
     */
    public static <T> Result<T> ok(T data, String codeOrMessage, Object[] args) {
        return new Result<>(Status.OK.code, MessageUtils.getMessage(codeOrMessage, args, codeOrMessage), data);
    }

    /**
     * 响应失败结果
     *
     * @param data 返回值
     * @param <T>  泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(Status.FAIL.code, Status.FAIL.getMessage(), data);
    }

    /**
     * 响应失败结果
     *
     * @param data          返回值
     * @param codeOrMessage 描述信息
     * @param <T>           泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data, String codeOrMessage) {
        return new Result<>(Status.FAIL.code, MessageUtils.getMessage(codeOrMessage, codeOrMessage), data);
    }

    /**
     * 响应失败结果
     *
     * @param data          返回值
     * @param codeOrMessage 描述信息
     * @param args          参数
     * @param <T>           泛型
     * @return Result对象
     */
    public static <T> Result<T> fail(T data, String codeOrMessage, Object[] args) {
        return new Result<>(Status.FAIL.code, MessageUtils.getMessage(codeOrMessage, args, codeOrMessage), data);
    }

    /**
     * 响应自定义结果
     *
     * @param data   返回值
     * @param status Status对象
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> customize(T data, Status status) {
        return new Result<>(status.code, status.getMessage(), data);
    }

    /**
     * 响应自定义结果
     *
     * @param data   返回值
     * @param status Status对象
     * @param args   参数
     * @param <T>    泛型
     * @return Result对象
     */
    public static <T> Result<T> customize(T data, Status status, Object[] args) {
        return new Result<>(status.code, status.getMessage(args), data);
    }

    /**
     * 响应自定义结果
     *
     * @param data          返回值
     * @param code          状态码
     * @param codeOrMessage 描述信息
     * @param <T>           泛型
     * @return Result对象
     */
    public static <T> Result<T> customize(T data, int code, String codeOrMessage) {
        return new Result<>(code, MessageUtils.getMessage(codeOrMessage, codeOrMessage), data);
    }

    /**
     * 响应自定义结果
     *
     * @param data          返回值
     * @param code          状态码
     * @param codeOrMessage 描述信息
     * @param args          参数
     * @param <T>           泛型
     * @return Result对象
     */
    public static <T> Result<T> customize(T data, int code, String codeOrMessage, Object[] args) {
        return new Result<>(code, MessageUtils.getMessage(codeOrMessage, args, codeOrMessage), data);
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
}
