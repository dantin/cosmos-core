package com.cosmos.core.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * 编解码工具基类
 *
 * @author David
 */
public abstract class EncodingUtils {

    /**
     * 用Base64方式加密字节数组
     *
     * @param rawBytes 原始字节数组
     * @return 编码后的字节数组
     */
    public static byte[] encodeBase64(byte[] rawBytes) {
        return Base64.encodeBase64(rawBytes);
    }

    /**
     * 用扩展Base64方式加密字节数组
     *
     * @param rawBytes 原始字节数组
     * @return 编码后的字节数组
     */
    public static byte[] encodeBase64Ex(byte[] rawBytes) {
        byte[] b64 = encodeBase64(rawBytes);

        // replace '/' with '_', '+" with '-'
        for (int i = 0; i < b64.length; i++) {
            if (b64[i] == '/') {
                b64[i] = '_';
            } else if (b64[i] == '+') {
                b64[i] = '-';
            }
        }

        return b64;
    }

    /**
     * 解码用Base64方式加密的字节数组
     *
     * @param encryptedBytes 加密字节数组
     * @return 解码后的字节数组
     */
    public static byte[] decodeBase64(byte[] encryptedBytes) {
        return Base64.decodeBase64(encryptedBytes);
    }

    /**
     * 解码用扩展Base64方式加密的字节数组
     *
     * @param encryptedBytes 加密字节数组
     * @return 解码后的字节数组
     */
    public static byte[] decodeBase64Ex(byte[] encryptedBytes) {

        // replace '_' with '/', '-' with '+'
        for (int i = 0; i < encryptedBytes.length; i++) {
            if (encryptedBytes[i] == '_') {
                encryptedBytes[i] = '/';
            } else if (encryptedBytes[i] == '-') {
                encryptedBytes[i] = '+';
            }
        }

        return decodeBase64(encryptedBytes);
    }

}
