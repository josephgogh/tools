package com.jg.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串操作类
 */
public class StringUtil {

    /**
     * 空字符串
     */
    public final static String EMPTY = "";

    /**
     * 未查找到字符串出现的位置
     */
    private final static int INDEX_NOT_FOUND = -1;

    /**
     * 将构造函数设置为私有的，不能被实例化，并且在被调用的时候抛出异常
     */
    private StringUtil() {
        throw new RuntimeException("工具表不能被实例化！");
    }

    /**
     * 判断字符串是否为空（""）或null
     * @param cs    待判断的字符串
     * @return  true：字符串为空（""）或null；false：字符串不为空
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 判断字符串是否不为空（""）并且不为null
     * @param cs    待判断的字符串
     * @return  true：字符串为为空；false：字符串为空（""）或null
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 返回一个字符串，
     * 如果字符串为空（""）或者null，则返回默认的字符串
     * @param str   待处理的字符串
     * @param defaultStr    默认值
     * @param <T>   字符串类型
     * @return  为空返回默认值，不为空返回值本身
     */
    public static <T extends CharSequence> T defaultIfEmpty(final T str, final T defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    /**
     * 返回一个字符串，
     * 如果字符串为null，则返回空字符串（""）
     * @param str   待处理的字符串
     * @return  str值为null，返回""；不为null，返回值本身
     */
    public static String emptyIfNull(final String str) {
        return isEmpty(str) ? EMPTY : str;
    }

    /**
     * 判断字符串是否为空格，或者为空（""），或者为null
     * @param cs    待判断的字符串
     * @return  true：字符串为空或字符串全部为空格；false：字符串不全为空格
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空格，并且不为空（""），并且不为null
     * @param cs    待判断的字符串
     * @return true：字符串不为空格，且不为空（""），且不为null；false：字符串为空格或空（""）或null
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 去除字符串的前后空格
     * @param str   待处理的字符串
     * @return  返回去除前后空格之后的字符串
     */
    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 去除字符串的前后空格，
     * 如果字符串去除前后空格之后为空，则返回null
     * @param str   待处理的字符串
     * @return  返回去除前后空格之后的字符串，字符串为空，返回null
     */
    public static String trimToNull(final String str) {
        final String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    /**
     * 去除字符串的前后空格，
     * 如果字符串为null，则返回空字符串
     * @param str   待处理的字符串
     * @return  返回去除前后空格之后的字符串，字符串为空，返回空（""）
     */
    public static String trimToEmpty(final String str) {
        return str == null ? EMPTY : str.trim();
    }

    /**
     * 判断字符串str1是否和字符串str2相等
     * @param str1  待判断的字符串1
     * @param str2  待判断的字符串2
     * @return  true：相等；false：不相等
     */
    public static boolean equals(final String str1, final String str2) {
        if (str1 == str2) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 在str1和str2的前后空格都去除之后
     * 判断字符串str1是否和字符串str2相等
     * @param str1  待判断的字符串1
     * @param str2  待判断的字符串2
     * @return  true：相等，false：不相等
     */
    public static boolean trimEquals(final String str1, final String str2) {
        if (str1 == str2) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return trim(str1).equals(trim(str2));
    }

    /**
     * 判断字符串str1是否和字符串str2相等（忽略字符串大小写）
     * @param str1  待比较字符串1
     * @param str2  待比较字符串2
     * @return  true：相等；false：不相等
     */
    public static boolean equalsIgnoreCase(final String str1, final String str2) {
        return equals(toLowerCase(str1), toLowerCase(str2));
    }

    /**
     * 判断字符串str1是否和字符串str2相等（忽略前后空格和字符串大小写）
     * @param str1  待比较字符串1
     * @param str2  待比较字符串2
     * @return  true：相等；false：不相等
     */
    public static boolean trimEqualsIgnoreCase(final String str1, final String str2) {
        return trimEquals(toLowerCase(str1), toLowerCase(str2));
    }

    /**
     * 查找searchStr第一次出现在str中的位置，没有返回-1
     * @param str   待查找的字符串
     * @param searchStr 需要查找的字符串
     * @return  返回第一次出现的位置，无则返回-1
     */
    public static int indexOf(final String str, final String searchStr) {
        if (str == null || searchStr == null) {
            return INDEX_NOT_FOUND;
        }
        return str.indexOf(searchStr);
    }

    /**
     * 查找searchStr第一次出现在str中的位置，没有返回-1（忽略大小写）
     * @param str   待查找的字符串
     * @param searchStr 需要查找的字符串
     * @return  返回第一次出现的位置，无则返回-1
     */
    public static int indexOfIgnoreCase(final String str, final String searchStr) {
        return indexOf(toLowerCase(str), toLowerCase(searchStr));
    }

    /**
     * 将字符串转为小写
     * @param str1  需要转换的字符串
     * @return  返回转换为小写的字符串
     */
    public static String toLowerCase(final String str1) {
        if (str1 == null) {
            return null;
        }
        return str1.toLowerCase();
    }

    /**
     * 将字符串转为大写
     * @param str1  需要转换的字符串
     * @return  返回转换为大写的字符串
     */
    public static String toUpperCase(final String str1) {
        if (str1 == null) {
            return null;
        }
        return str1.toUpperCase();
    }

    /**
     * 判断字符串str是否包含有字符串searchStr
     * @param str   父字符串
     * @param searchStr 子字符串
     * @return  true：包含；false：不包含
     */
    public static boolean contains(final String str, final String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return str.contains(searchStr);
    }

    /**
     * 判断字符串str是否包含有字符串searchStr（忽略字符串大小写）
     * @param str   父字符串
     * @param searchStr 子字符串
     * @return  true：包含；false：不包含
     */
    public static boolean containsIgnoreCase(final String str, final String searchStr) {
        return contains(toLowerCase(str), toLowerCase(searchStr));
    }

    /**
     * 从start开始截取字符串
     * @param str   待截取的字符串
     * @param start 开始截取的位置
     * @return  返回截取完的字符串
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = str.length() + start;
        }
        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return EMPTY;
        }
        return str.substring(start);
    }

    /**
     * 截取字符串从start开始到end结束
     * @param str   待截取的字符串
     * @param start 开始截取的位置
     * @param end   结束截取的位置
     * @return  返回截取完的字符串
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return EMPTY;
        }
        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }
        return str.substring(start, end);
    }

    /**
     * 从左边开始截取len个字符
     * @param str   待截取的字符串
     * @param len   截取的长度
     * @return  返回从左边开始截取len个字符的字符串
     */
    public static String left(final String str, final int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }

    /**
     * 从右边开始截取len个字符串
     * @param str   待截取的字符串
     * @param len   截取的字符串长度
     * @return  返回从右边开始截取len个字符的字符串
     */
    public static String right(final String str, final int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }

    /**
     * 从第pos个字符开始截取长度为len的字符串
     * @param str   待截取的字符串
     * @param pos   开始截取的位置
     * @param len   截取的字符串长度
     * @return  从第pos个字符开始截取len个字符的字符串
     */
    public static String mid(final String str, int pos, final int len) {
        if (str == null) {
            return null;
        }
        if (len < 0 || pos > str.length()) {
            return EMPTY;
        }
        if (pos < 0) {
            pos = 0;
        }
        if (str.length() <= pos + len) {
            return str.substring(pos);
        }
        return str.substring(pos, pos + len);
    }

    /**
     * 截取str中第一次出现separator之前的内容
     * @param str   待截取的字符串
     * @param separator 截取separator之前的参数
     * @return  截取str中第一次出现separator之前的字符串
     */
    public static String substringBefore(final String str, final String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.isEmpty()) {
            return EMPTY;
        }
        final int pos = str.indexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * 截取str中第一次出现separator之后的内容
     * @param str   待截取的字符串
     * @param separator 截取separator之后的参数
     * @return  截取str中第一次出现separator之后的参数
     */
    public static String substringAfter(final String str, final String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return EMPTY;
        }
        final int pos = str.indexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * 截取str中最后一次出现separator之前的内容
     * @param str   待截取的字符串
     * @param separator 截取separator之前的参数
     * @return  截取str中最后一次出现separator之前的字符串
     */
    public static String substringBeforeLast(final String str, final String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        final int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * 截取str中最后一次出现separator之后的内容
     * @param str   待截取的字符串
     * @param separator 截取separator之后的参数
     * @return  截取str中最后一次出现separator之后的字符串
     */
    public static String substringAfterLast(final String str, final String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(separator)) {
            return EMPTY;
        }
        final int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND || pos == str.length() - separator.length()) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * 截取str中open之后close之前的内容
     * @param str   待截取的字符串
     * @param open  截取open之后的参数
     * @param close 截取close之前的参数
     * @return  截取str中open之后close之前的字符串
     */
    public static String substringBetween(final String str, final String open, final String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        final int start = str.indexOf(open);
        if (start != INDEX_NOT_FOUND) {
            final int end = str.indexOf(close, start + open.length());
            if (end != INDEX_NOT_FOUND) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }



}
