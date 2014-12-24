package com.cosmos.core.utils;

import junit.framework.TestCase;

public class RandomUtilsTest extends TestCase {

    public void testGetRandomCode() {
        final int SIZE = 4;
        assertEquals(SIZE, RandomUtils.getRandomCode(SIZE).length());
    }
}
