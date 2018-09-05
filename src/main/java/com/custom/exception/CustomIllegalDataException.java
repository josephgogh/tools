package com.custom.exception;

/**
 * 自定义异常：非法数据
 */
public class CustomIllegalDataException extends RuntimeException {

    private static final long serialVersionUID = -8852116550004345682L;

    public CustomIllegalDataException() {
        super();
    }

    public CustomIllegalDataException(String message) {
        super(message);
    }

    public CustomIllegalDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomIllegalDataException(Throwable cause) {
        super(cause);
    }

    protected CustomIllegalDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 抛出一个自定义的非法数据异常
     * @param message   异常信息
     */
    public static void throwException(String message) {
        throw new CustomIllegalDataException(message);
    }

}
