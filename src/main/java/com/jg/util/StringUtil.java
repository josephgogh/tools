package com.jg.util;

/**
 * 字符串操作工具类
 *
 * @author huangyong
 * @since 1.0
 */
public class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

}
