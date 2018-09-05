package com.custom.exception;

/**
 * 自定义异常
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -7123589623045098992L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    protected CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 抛出一个自定义的异常
     * @param message   异常信息
     */
    public static void throwException(String message) {
        throw new CustomException(message);
    }
}
