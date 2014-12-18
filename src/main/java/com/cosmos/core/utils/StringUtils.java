package com.cosmos.core.utils;

import com.cosmos.core.exception.BusinessException;

import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 *
 * @author David
 */
public abstract class StringUtils {

    public static final String UTF_8 = "utf-8";

    /**
     * 用UTF-8编码将字符串转成字节数组
     *
     * @param string 字符串
     * @return 字节数组
     */
    public static byte[] toBytes(String string) {
        return toBytes(string, UTF_8);
    }

    /**
     * 用特定编码将字符串转成字节数组
     *
     * @param string  字符串
     * @param charset 编码方式
     * @return 字节数组
     */
    public static byte[] toBytes(String string, String charset) {
        try {
            return string.getBytes(charset);
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
        return toString(bytes, UTF_8);
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
