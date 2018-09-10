package com.custom.util;

import com.custom.exception.CustomException;
import com.custom.exception.CustomParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

    private DateUtil() {
        CustomException.throwException("工具类不能实例化！");
    }

    /**
     * 格式化日期
     * @param date  日期
     * @param format    日期格式
     * @return  日期格式的字符串
     */
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format)
                .format(date);
    }

    /**
     * 获取日期
     * @param str  日期格式的字符串
     * @param format    日期格式
     * @return  获取日期
     */
    public static Date getDate(String str, String format) {
        try {
            return new SimpleDateFormat(format)
                    .parse(str);
        } catch (ParseException e) {
            CustomParseException.throwException("日期解析异常！");
        }
        return null;
    }

}
