package com.custom.util;

import com.custom.exception.CustomCryptionException;
import com.custom.exception.CustomException;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * 加密工具类
 */
public class CryptionUtil {

    private CryptionUtil() {
        CustomException.throwException("工具类不能实例化！");
    }

    /**
     * des加密
     * @param data  待加密数据
     * @param desKey    秘钥（长度为8的字节数组）
     * @return  加密之后的数据
     */
    public static String encryptBasedDes(final String data, byte[] desKey) {
        String result = data;
        if (data == null) {
            return "";
        }
        try {
            //DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec ds = new DESKeySpec(desKey);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(ds);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            result = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            CustomCryptionException.throwException("加密错误，错误信息：\n" + e.getMessage());
        }
        return result;
    }

    /**
     * des解密
     * @param cryptData 待解密数据
     * @param desKey    秘钥（长度为8的字节数组）
     * @return  解密之后的数据
     */
    public static String decryptBasedDes(final String cryptData, byte[] desKey) {
        String result = cryptData;
        if (cryptData == null) {
            return "";
        }
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec ds = new DESKeySpec(desKey);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(ds);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串解码为字节数组，并解密
            result = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            CustomCryptionException.throwException("解密错误，错误信息：\n" + e.getMessage());
        }
        return result;
    }

    /**
     * md5加密
     * @param data  待加密数据
     * @return  加密之后的数据
     */
    public static String encryptBasedMd5(final String data) {
        if (data == null) {
            return "";
        }
        String result = data;
        try {
            //确定计算方法
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            result = base64en.encode(md5.digest(data.getBytes("utf-8")));
        } catch (Exception e) {
            CustomCryptionException.throwException("加密错误，错误信息：\n" + e.getMessage());
        }
        return result;
    }

}
