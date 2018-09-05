package com.custom.exception;

/**
 * 自定义异常：非法参数
 */
public class CustomIllegalArgumentException extends RuntimeException {

    private static final long serialVersionUID = 2874386188886624304L;

    public CustomIllegalArgumentException() {
        super();
    }

    public CustomIllegalArgumentException(String message) {
        super(message);
    }

    public CustomIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomIllegalArgumentException(Throwable cause) {
        super(cause);
    }

    protected CustomIllegalArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 抛出一个自定义的非法参数异常
     * @param message   异常信息
     */
    public static void throwException(String message) {
        throw new CustomIllegalArgumentException(message);
    }
}
