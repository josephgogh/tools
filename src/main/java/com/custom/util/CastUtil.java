package com.custom.util;

import com.custom.exception.CustomException;

/**
 * 转型操作工具类
 */
public class CastUtil {

    /**
     * 私有化构造函数
     */
    private CastUtil() {
        CustomException.throwException("工具类不能实例化！");
    }

    /**
     * 将对象转为String类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  String类型的对象
     */
    public static String castString(final Object obj, final String defaultValue) {
        return obj == null ? defaultValue : obj.toString();
    }

    /**
     * 将对象转为String类型
     * null对象转为""
     * @param obj 待转换对象
     * @return String类型的对象
     */
    public static String castString(final Object obj) {
        return castString(obj, StringUtil.EMPTY);
    }

    /**
     * 将对象转为double类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  double类型的对象
     */
    public static double castDouble(final Object obj, final double defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        String str = castString(obj);
        if (StringUtil.isEmpty(str)) {
            return defaultValue;
        }
        return Double.parseDouble(str);
    }

    /**
     * 将对象转为double类型
     * null对象转为0
     * @param obj   待转换对象
     * @return  double类型的对象
     */
    public static double castDouble(final Object obj) {
        return castDouble(obj, 0);
    }

    /**
     * 将对象转为float类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  float类型的对象
     */
    public static float castFloat(final Object obj, final float defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        String str = castString(obj);
        if (StringUtil.isEmpty(str)) {
            return defaultValue;
        }
        return Float.parseFloat(str);
    }

    /**
     * 将对象转为float类型
     * null对象转为0
     * @param obj   待转换对象
     * @return  float类型的对象
     */
    public static float castFloat(final Object obj) {
        return castFloat(obj, 0);
    }

    /**
     * 将对象转为long类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  long类型的对象
     */
    public static long castLong(final Object obj, final long defaultValue) {
        return (long) castDouble(obj, defaultValue);
    }

    /**
     * 将对象转为long类型
     * null对象转为0
     * @param obj   待转换对象
     * @return  long类型的对象
     */
    public static long castLong(final Object obj) {
        return castLong(obj, 0);
    }

    /**
     * 将对象转为int类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  int类型的对象
     */
    public static int castInt(final Object obj, final int defaultValue) {
        return (int) castDouble(obj, defaultValue);
    }

    /**
     * 将对象转为int类型
     * null对象转为0
     * @param obj   待转换对象
     * @return  int类型的对象
     */
    public static int castInt(final Object obj) {
        return castInt(obj, 0);
    }

    /**
     * 将对象转为short类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  short类型的对象
     */
    public static short castShort(final Object obj, final short defaultValue) {
        return (short) castDouble(obj, defaultValue);
    }

    /**
     * 将对象转为short类型
     * null对象转为0
     * @param obj   待转换对象
     * @return  short类型的对象
     */
    public static short castShort(final Object obj) {
        return castShort(obj, (short) 0);
    }

    /**
     * 将对象转为boolean类型
     * null对象转为defaultValue
     * @param obj   待转换对象
     * @param defaultValue  默认值
     * @return  boolean类型的对象
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        String str = castString(obj);
        if (StringUtil.isEmpty(str)) {
            return defaultValue;
        }
        return Boolean.parseBoolean(str);
    }

    /**
     * 将double对象转为boolean类型
     * 0 返回false
     * 其它值返回true
     * @param d 待转换对象
     * @return  boolean类型的对象
     */
    public static boolean castBoolean(double d) {
        return (d != 0);
    }

    /**
     * 将对象转为boolean类型
     * null对象转为true
     * @param obj   待转换对象
     * @return  boolean类型的对象
     */
    public static boolean castBooleanDefaultTrue(Object obj) {
        return castBoolean(obj, true);
    }

    /**
     * 将对象转为boolean类型
     * null对象转为false
     * @param obj   待转换对象
     * @return  boolean类型的对象
     */
    public static boolean castBooleanDefaultFalse(Object obj) {
        return castBoolean(obj, false);
    }

}
