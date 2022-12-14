package com.neweasesoft.dataplus.framework.common.coc.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller处理请求的通用模板
 */
public class RequestHandlerTemplate {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandlerTemplate.class);

    // 业务执行时间的阈值
    private static final long THRESHOLD = 10_000L;

    private RequestHandlerTemplate() {
    }

    private void validation() {
    }
}
