package com.neweasesoft.dataplus.framework.web.coc;

import lombok.AllArgsConstructor;

/**
 * 请求响应状态码枚举类
 *
 * @author fushuwei
 */
@AllArgsConstructor
public enum Status {
    OK(10000, "result.message.ok"),
    FAIL(99999, "result.message.fail");

    /**
     * 状态码
     */
    final int code;

    /**
     * 状态码对应的国际化名称
     */
    final String i18n;
}
