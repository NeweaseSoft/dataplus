package com.neweasesoft.dataplus.framework.web.i18n;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 国际化工具类
 *
 * @author fushuwei
 */
public class MessageUtil {

    private static final ResourceBundleMessageSource messageSource;

    static {
        messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        messageSource.setBasenames("i18n/messages");
    }

    /**
     * 获取国际化翻译
     *
     * @param code 国际化代码
     * @return 翻译
     */
    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, "国际化 [" + code + "] 缺失", LocaleContextHolder.getLocale());
    }

    /**
     * 获取国际化翻译
     *
     * @param code 国际化代码
     * @param args 参数
     * @return 翻译
     */
    public static String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, "国际化 [" + code + "] 缺失", LocaleContextHolder.getLocale());
    }

    /**
     * 获取国际化翻译
     *
     * @param code           国际化代码
     * @param args           参数
     * @param defaultMessage 默认值
     * @return 翻译
     */
    public static String getMessage(String code, Object[] args, String defaultMessage) {
        return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
    }
}
