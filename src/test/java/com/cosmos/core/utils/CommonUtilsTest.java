package com.cosmos.core.utils;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class CommonUtilsTest extends TestCase {

    private List<String> strings;

    private List<Class<?>> classes;

    private List<Integer> iList1;

    private List<Integer> iList2;

    @Override
    public void setUp() {
        this.strings = Arrays.asList("one", "two", "two", "three");
        this.classes = Arrays.asList(new Class<?>[]{Integer.class, Long.class, Long.class, Double.class});
        this.iList1 = Arrays.asList(1, 2, 3, 3);
        this.iList2 = Arrays.asList(3, 3, 4, 5);
    }

    @Override
    public void tearDown() {
        // do nothings here
    }

    public void testDeduplicate() {
        List<String> deduplicatedStrings = CommonUtils.deduplicate(strings);

        assertEquals(strings.size() - 1, deduplicatedStrings.size());

        List<Class<?>> deduplicatedClasses = CommonUtils.deduplicate(classes);

        assertEquals(classes.size() - 1, deduplicatedClasses.size());
    }

    public void testDeduplicatedMerge() {
        List<Integer> mergedIntegerList = CommonUtils.deduplicatedMerge(iList1, iList2);

        assertEquals(iList1.size() + iList2.size() - 3, mergedIntegerList.size());
    }
}
