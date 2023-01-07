package com.neweasesoft.dataplus.framework.web.coc;

import com.neweasesoft.dataplus.framework.web.i18n.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求响应状态码枚举类
 *
 * @author fushuwei
 */
@AllArgsConstructor
public enum Status {

    /**
     * 10000 ~ 19999 : 表示后端接口处理请求成功
     */
    OK(10000, "result.message.ok"),
    OK_SAVE(10001, "result.message.save.ok"),
    OK_UPDATE(10002, "result.message.update.ok"),
    OK_DELETE(10003, "result.message.delete.ok"),

    /**
     * 30000 ~ 39999 : 表示前端页面用info图标提示message, 如部分成功
     */
    INFO(30000, "result.message.info"),

    /**
     * 50000 ~ 59999 : 表示前端页面用confirm图标提示message, 如二次确认
     */
    CONFIRM(50000, "result.message.confirm"),


    /**
     * 70000 ~ 79999 : 表示前端页面用warn图标提示message, 如表单校验不通过
     */
    WARN(70000, "result.message.warn"),

    /**
     * 90000 ~ 99999 : 表示后端接口处理请求失败
     */
    FAIL_SAVE(90001, "result.message.save.fail"),
    FAIL_UPDATE(90002, "result.message.update.fail"),
    FAIL_DELETE(90003, "result.message.delete.fail"),
    FAIL(99999, "result.message.fail");

    /**
     * 状态码
     */
    @Getter
    final int code;

    /**
     * 状态码对应的国际化名称
     */
    @Getter
    final String i18n;

    /**
     * 获取国际化翻译
     *
     * @return 翻译值
     */
    public String getMessage() {
        return MessageUtils.getMessage(i18n);
    }

    /**
     * 获取国际化翻译
     *
     * @param defaultMessage 默认值
     * @return 翻译值
     */
    public String getMessage(String defaultMessage) {
        return MessageUtils.getMessage(i18n, defaultMessage);
    }

    /**
     * 获取国际化翻译
     *
     * @param args 参数
     * @return 翻译值
     */
    public String getMessage(Object[] args) {
        return MessageUtils.getMessage(i18n, args);
    }

    /**
     * 获取国际化翻译
     *
     * @param args           参数
     * @param defaultMessage 默认值
     * @return 翻译值
     */
    public String getMessage(Object[] args, String defaultMessage) {
        return MessageUtils.getMessage(i18n, args, defaultMessage);
    }
}
