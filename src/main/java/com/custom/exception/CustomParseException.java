package com.custom.exception;

/**
 * 自定义异常，转换异常
 */
public class CustomParseException extends RuntimeException {

    public CustomParseException() {
        super();
    }

    public CustomParseException(String message) {
        super(message);
    }

    public CustomParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomParseException(Throwable cause) {
        super(cause);
    }

    protected CustomParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 抛出一个自定义的解析异常
     * @param message   异常信息
     */
    public static void throwException(String message) {
        throw new CustomParseException(message);
    }
}
