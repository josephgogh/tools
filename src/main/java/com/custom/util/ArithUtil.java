package com.custom.util;

import com.custom.exception.CustomException;
import com.custom.exception.CustomIllegalArgumentException;

import java.math.BigDecimal;

/**
 * 浮点数运算工具类
 */
public class ArithUtil {

    /**
     * 默认除法运算精度
     */
    private static final int DEF_DIV_SCALE = 10;

    private ArithUtil() {
        CustomException.throwException("工具类不能实例化！");
    }

    /**
     * 加法运算
     * @param add1    加数1
     * @param add2    加数2
     * @return  两个参数的和
     */
    public static double add(double add1, double add2) {
        BigDecimal b1 = new BigDecimal(CastUtil.castString(add1));
        BigDecimal b2 = new BigDecimal(CastUtil.castString(add2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 减法运算
     * @param minuend       被减数
     * @param subtrahend    减数
     * @return  两个参数的差
     */
    public static double sub(double minuend, double subtrahend) {
        BigDecimal b1 = new BigDecimal(CastUtil.castString(minuend));
        BigDecimal b2 = new BigDecimal(CastUtil.castString(subtrahend));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 乘法运算
     * @param mul1  乘数1
     * @param mul2  乘数2
     * @return  两个参数的积
     */
    public static double mul(double mul1, double mul2) {
        BigDecimal b1 = new BigDecimal(CastUtil.castString(mul1));
        BigDecimal b2 = new BigDecimal(CastUtil.castString(mul2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 除法运算（默认精确到小数点后10位）
     * @param dividend  被除数
     * @param divisor   除数
     * @return  两个参数的商
     */
    public static double div(double dividend, double divisor) {
        return div(dividend, divisor, DEF_DIV_SCALE);
    }

    /**
     * 除法运算
     * @param dividend  被除数
     * @param divisor   除数
     * @param scale 表示需要精确到小数点后面的位数
     * @return  两个参数的商
     */
    public static double div(double dividend, double divisor, int scale) {
        if (scale < 0) {
            CustomIllegalArgumentException.throwException("scale不能为负数！");
        }
        BigDecimal b1 = new BigDecimal(CastUtil.castString(dividend));
        BigDecimal b2 = new BigDecimal(CastUtil.castString(divisor));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 四舍五入
     * @param value 值
     * @param scale 表示需要精确到小数点后面的位数
     * @return  四舍五入之后的值
     */
    public static double round(double value, int scale) {
        if (scale < 0) {
            CustomIllegalArgumentException.throwException("scale不能为负数！");
        }
        BigDecimal b1 = new BigDecimal(CastUtil.castString(value));
        return b1.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
