package com.cosmos.core.utils;

import com.cosmos.core.exception.BusinessException;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

public class ClassUtilsTest extends TestCase {

    public void testGetAllSubClass() {
        List<Class<? extends BusinessException>> classes = null;
        try {
            classes = ClassUtils.getAllSubClass("com.cosmos", BusinessException.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(classes);
        assertEquals(0, classes.size());
    }

    public void testGetAllClass() {
        List<Class<?>> classes = null;
        try {
            classes = ClassUtils.getAllClass("com.cosmos.core.exception");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(classes);
        assertEquals(3, classes.size());
    }
}
