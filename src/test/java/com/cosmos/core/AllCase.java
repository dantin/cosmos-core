package com.cosmos.core;

import com.cosmos.core.utils.ClassUtilsTest;
import com.cosmos.core.utils.CommonUtilsTest;
import junit.extensions.ActiveTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Bootstrap of all test cases
 *
 * @author David
 */
public class AllCase {

    public static Test suite() {
        TestSuite suite = new ActiveTestSuite();

        suite.addTestSuite(CommonUtilsTest.class);
        suite.addTestSuite(ClassUtilsTest.class);

        return suite;
    }
}
