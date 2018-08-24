package com.jg.util;

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
    public final static int INDEX_NOT_FOUND = -1;

    /**
     * 判断字符串是否为空（""）或null
     * @param cs
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 判断字符串是否不为空（""）并且不为null
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 返回一个字符串，
     * 如果字符串为空（""）或者null，则返回默认的字符串
     * @param str
     * @param defaultStr
     * @param <T>
     * @return
     */
    public static <T extends CharSequence> T defaultIfEmpty(final T str, final T defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    /**
     * 返回一个字符串，
     * 如果字符串为null，则返回空字符串（""）
     * @param str
     * @return
     */
    public static String emptyIfNull(final String str) {
        return isEmpty(str) ? EMPTY : str;
    }

    /**
     * 判断字符串是否为空格，或者为空（""），或者为null
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空格，并且不为空（""），并且不为null
     * @param cs
     * @return
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 去除字符串的前后空格
     * @param str
     * @return
     */
    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 去除字符串的前后空格，
     * 如果字符串去除前后空格之后为空，则返回null
     * @param str
     * @return
     */
    public static String trimToNull(final String str) {
        final String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    /**
     * 去除字符串的前后空格，
     * 如果字符串为null，则返回空字符串
     * @param str
     * @return
     */
    public static String trimToEmpty(final String str) {
        return str == null ? EMPTY : str.trim();
    }

    /**
     * 判断字符串str1是否和字符串str2相等
     * @param str1
     * @param str2
     * @return
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
     * @param str1
     * @param str2
     * @return
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
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equalsIgnoreCase(final String str1, final String str2) {
        return equals(toLowerCase(str1), toLowerCase(str2));
    }

    /**
     * 判断字符串str1是否和字符串str2相等（忽略前后空格和字符串大小写）
     * @param str1
     * @param str2
     * @return
     */
    public static boolean trimEqualsIgnoreCase(final String str1, final String str2) {
        return trimEquals(toLowerCase(str1), toLowerCase(str2));
    }

    /**
     * 查找searchSeq第一次出现在seq中的位置，没有返回-1
     * @param seq
     * @param searchSeq
     * @return
     */
    public static int indexOf(final String seq, final String searchSeq) {
        if (seq == null || searchSeq == null) {
            return INDEX_NOT_FOUND;
        }
        return seq.indexOf(searchSeq);
    }

    /**
     * 查找searchSeq第一次出现在seq中的位置，没有返回-1（忽略大小写）
     * @param seq
     * @param searchSeq
     * @return
     */
    public static int indexOfIgnoreCase(final String seq, final String searchSeq) {
        return indexOf(toLowerCase(seq), toLowerCase(searchSeq));
    }

    /**
     * 将字符串转为小写
     * @param str1
     * @return
     */
    public static String toLowerCase(final String str1) {
        if (str1 == null) {
            return null;
        }
        return str1.toLowerCase();
    }

    /**
     * 将字符串转为大写
     * @param str1
     * @return
     */
    public static String toUpperCase(final String str1) {
        if (str1 == null) {
            return null;
        }
        return str1.toUpperCase();
    }

    /**
     * 判断字符串seq是否包含有字符串searchSeq
     * @param seq
     * @param searchSeq
     * @return
     */
    public static boolean contains(final String seq, final String searchSeq) {
        if (seq == null || searchSeq == null) {
            return false;
        }
        return seq.contains(searchSeq);
    }

    /**
     * 判断字符串seq是否包含有字符串searchSeq（忽略字符串大小写）
     * @param seq
     * @param searchSeq
     * @return
     */
    public static boolean containsIgnoreCase(final String seq, final String searchSeq) {
        return contains(toLowerCase(seq), toLowerCase(searchSeq));
    }

    /**
     * 从start开始截取字符串
     * @param str
     * @param start
     * @return
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
     * @param str
     * @param start
     * @param end
     * @return
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

}
