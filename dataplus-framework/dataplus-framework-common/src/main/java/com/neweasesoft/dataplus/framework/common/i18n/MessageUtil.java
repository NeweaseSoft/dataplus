package com.neweasesoft.dataplus.framework.common.i18n;

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
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.toString());
        messageSource.setBasenames("i18n/messages");
    }

    public static String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

    public static String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }
}
