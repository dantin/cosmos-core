package com.cosmos.core.net.http;

import junit.framework.TestCase;

public class HttpAgentTest extends TestCase {

    public void testGet() {
        HttpAgent agent = new HttpAgent();
        HttpCallResponse response = agent.get("http://127.0.0.1");
        System.out.println(response.getResponse());
    }
}
