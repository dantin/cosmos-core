package com.cosmos.core.utils;

import junit.framework.TestCase;

public class EncodingUtilsTest extends TestCase {

    private String raw;

    private String encrypted;

    private String encryptedEx;

    @Override
    public void setUp() {
        this.raw = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+}{:?><-=,./;'[]";
        this.encrypted = "MTIzNDU2Nzg5MGFiY2RlZmdoaWprbG1ub3BxcnN0dXZ3eHl6QUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVp+IUAjJCVeJiooKV8rfXs6Pz48LT0sLi87J1td";
        this.encryptedEx = "MTIzNDU2Nzg5MGFiY2RlZmdoaWprbG1ub3BxcnN0dXZ3eHl6QUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVp-IUAjJCVeJiooKV8rfXs6Pz48LT0sLi87J1td";
    }

    @Override
    public void tearDown() {
        // do nothings here
    }

    public void testDecodeBase64() {
        assertEquals(raw, StringUtils.toString(EncodingUtils.decodeBase64(StringUtils.toBytes(encrypted))));
    }

    public void testDecodeBase64Ex() {
        assertEquals(raw, StringUtils.toString(EncodingUtils.decodeBase64Ex(StringUtils.toBytes(encryptedEx))));
    }

    public void testEncodeBase64() {
        assertEquals(encrypted, StringUtils.toString(EncodingUtils.encodeBase64(StringUtils.toBytes(raw))));
    }

    public void testEncodeBase64Ex() {
        assertEquals(encryptedEx, StringUtils.toString(EncodingUtils.encodeBase64Ex(StringUtils.toBytes(raw))));
    }
}
