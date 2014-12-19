package com.cosmos.core.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个实现RFC 4648定义的Base64加解密工具类，用于URL和文件名的编解码
 *
 * @author David
 */
public abstract class UrlEncodingUtils extends EncodingUtils {

    /**
     * 用自定义的Base64编码URL
     *
     * @param url URL字符串
     * @return 编码后的URL字符串
     */
    public static String safeEncodeUrlToString(String url) {
        return StringUtils.toString(encodeBase64Ex(StringUtils.toBytes(url)));
    }

    /**
     * 用Base64编码URL
     *
     * @param url URL字符串
     * @return 编码后的URL字符串
     */
    public static String encodeUrlToString(String url) {
        return StringUtils.toString(encodeBase64(StringUtils.toBytes(url)));
    }

    /**
     * 用自定义的Base64解码编码后的URL
     *
     * @param encodedUrl 经过编码的URL
     * @return 原始URL
     */
    public static String safeDecodeUrlToString(String encodedUrl) {
        return StringUtils.toString(encodeBase64Ex(StringUtils.toBytes(encodedUrl)));
    }

    /**
     * 用Base64解码编码后的URL
     *
     * @param encodedUrl 经过编码的URL
     * @return 原始URL
     */
    public static String decodeUrlToString(String encodedUrl) {
        return StringUtils.toString(encodeBase64(StringUtils.toBytes(encodedUrl)));
    }

    /**
     * 用UTF-8字符集编码URL中的参数
     *
     * @param params URL参数
     * @return 编码结果
     */
    public static String encodeParams(Object params) {
        return encodeParams(params, StringUtils.UTF_8);
    }

    /**
     * 用指定字符集编码URL中的参数
     *
     * @param params  URL参数
     * @param charset 特定字符集
     * @return 编码结果
     */
    public static String encodeParams(Object params, String charset) {
        if (params instanceof String) {
            return (String) params;
        }

        if (params instanceof HashMap<?, ?>) {
            @SuppressWarnings("unchecked")
            Map<String, String> map = (HashMap<String, String>) params;
            ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            return URLEncodedUtils.format(list, charset);
        }

        return null;
    }
}
