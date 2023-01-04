package com.neweasesoft.dataplus.framework.web.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Objects;

/**
 * 国际化地区配置变更拦截器
 *
 * @author fushuwei
 */
public class LocaleChangeHandlerInterceptor extends LocaleChangeInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        String newLocale = request.getHeader(getParamName());
        Locale locale = localeResolver.resolveLocale(request);
        if (newLocale != null && !newLocale.equalsIgnoreCase(locale.toString())) {
            localeResolver.setLocale(request, response, StringUtils.parseLocaleString(newLocale));
        }
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) {
        if (null != modelAndView) {
            Locale locale = Objects.requireNonNull(RequestContextUtils.getLocaleResolver(request)).resolveLocale(request);
            modelAndView.setViewName(locale + "/" + modelAndView.getViewName());
        }
    }
}
