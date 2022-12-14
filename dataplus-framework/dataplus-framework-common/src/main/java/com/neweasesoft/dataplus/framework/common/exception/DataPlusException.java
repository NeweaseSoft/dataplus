package com.neweasesoft.dataplus.framework.common.exception;

import org.apache.commons.lang3.StringUtils;

public class DataPlusException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private DataPlusException(ErrorCode code) {
        super(code.toString());
    }

    private DataPlusException(ErrorCode code, String message) {
        super(StringUtils.join(code, "\n\n", message));
    }

    private DataPlusException(ErrorCode code, String message, Throwable cause) {
        super(StringUtils.join(code, "\n\n", message), cause);
    }

    private DataPlusException(ErrorCode code, Throwable cause) {
        super(code.toString(), cause);
    }

    public static DataPlusException newInstance(ErrorCode code) {
        return new DataPlusException(code);
    }

    public static DataPlusException newInstance(ErrorCode code, String message) {
        return new DataPlusException(code, message);
    }

    public static DataPlusException newInstance(ErrorCode code, String message, Throwable cause) {
        if (cause instanceof DataPlusException) {
            return (DataPlusException) cause;
        }
        return new DataPlusException(code, message, cause);
    }

    public static DataPlusException newInstance(ErrorCode code, Throwable cause) {
        if (cause instanceof DataPlusException) {
            return (DataPlusException) cause;
        }
        return new DataPlusException(code, cause);
    }
}
