package com.cosmos.core;

import com.cosmos.core.net.http.HttpAgentTest;
import com.cosmos.core.utils.ClassUtilsTest;
import com.cosmos.core.utils.CommonUtilsTest;
import com.cosmos.core.utils.EncodingUtilsTest;
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
        suite.addTestSuite(EncodingUtilsTest.class);
        suite.addTestSuite(HttpAgentTest.class);

        return suite;
    }
}
