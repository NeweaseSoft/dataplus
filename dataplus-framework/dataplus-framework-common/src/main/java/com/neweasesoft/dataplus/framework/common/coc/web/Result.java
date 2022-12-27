package com.neweasesoft.dataplus.framework.common.coc.web;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应数据封装类
 *
 * @author fushuwei
 */
@Data
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
    private T result;

    public static <T> Result<T> ok(int code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setResult(data);
        return result;
    }
}
