package com.cosmos.core.utils;

import java.util.Random;

/**
 * 随机数工具类
 *
 * @author David
 */
public abstract class RandomUtils {

    private static final Random random = new Random(System.currentTimeMillis());

    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 获取随机n位数字码
     *
     * @param length 数字码长度
     * @return 随机数字码
     */
    public static String getRandomCode(final int length) {
        StringBuilder code = new StringBuilder(length);

        for(int i = 0; i < length; i++) {
            code.append(NUMBERS[random.nextInt(NUMBERS.length)]);
        }
        return code.toString();
    }
}
