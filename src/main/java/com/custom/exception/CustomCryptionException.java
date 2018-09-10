package com.custom.exception;

/**
 * 自定义异常，加密异常
 */
public class CustomCryptionException extends RuntimeException {

    public CustomCryptionException() {
        super();
    }

    public CustomCryptionException(String message) {
        super(message);
    }

    public CustomCryptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomCryptionException(Throwable cause) {
        super(cause);
    }

    protected CustomCryptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 抛出自定义异常，加密异常
     * @param message   异常信息
     */
    public static void throwException(String message) {
        throw new CustomCryptionException(message);
    }
}
