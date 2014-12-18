package com.cosmos.core.utils;

import com.cosmos.core.exception.BusinessException;

import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 *
 * @author David
 */
public abstract class StringUtils {

    public static final String DEFAULT_CHARSET = "utf-8";

    /**
     * 用UTF-8编码将字符串转成字节数组
     *
     * @param s 字符串
     * @return 字节数组
     */
    public static byte[] toByte(String s) {
        return toByte(s, DEFAULT_CHARSET);
    }

    /**
     * 用特定编码将字符串转成字节数组
     *
     * @param s       字符串
     * @param charset 编码方式
     * @return 字节数组
     */
    public static byte[] toByte(String s, String charset) {
        try {
            return s.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(e);
        }
    }

    /**
     * 用UTF-8编码将字节数组转成字符串
     *
     * @param bytes 字节数组
     * @return 字符串
     */
    public static String toString(byte[] bytes) {
        return toString(bytes, DEFAULT_CHARSET);
    }

    /**
     * 用特定编码将字节数组转成字符串
     *
     * @param bytes   字节数组
     * @param charset 编码方式
     * @return 字符串
     */
    public static String toString(byte[] bytes, String charset) {
        try {
            return new String(bytes, charset);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(e);
        }
    }
}
