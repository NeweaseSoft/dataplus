package com.neweasesoft.dataplus.framework.web.coc;

import com.neweasesoft.dataplus.framework.web.i18n.MessageUtils;
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

    /**
     * 获取国际化翻译
     *
     * @return 翻译值
     */
    public String getMessage() {
        return MessageUtils.getMessage(Status.OK.i18n);
    }

    /**
     * 获取国际化翻译
     *
     * @param defaultMessage 默认值
     * @return 翻译值
     */
    public String getMessage(String defaultMessage) {
        return MessageUtils.getMessage(Status.OK.i18n, defaultMessage);
    }

    /**
     * 获取国际化翻译
     *
     * @param args 参数
     * @return 翻译值
     */
    public String getMessage(Object[] args) {
        return MessageUtils.getMessage(Status.OK.i18n, args);
    }

    /**
     * 获取国际化翻译
     *
     * @param args           参数
     * @param defaultMessage 默认值
     * @return 翻译值
     */
    public String getMessage(Object[] args, String defaultMessage) {
        return MessageUtils.getMessage(Status.OK.i18n, args, defaultMessage);
    }
}
