package com.cosmos.core.net.http;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreConnectionPNames;

/**
 * 一个HttpConnectionPool实现类
 *
 * @author David
 */
public class Http {

    // 默认的HTTP连接超时时间，单位：秒
    public static int DEFAULT_CONNECTION_TIMEOUT = 30 * 1000;

    // 默认的读取response超时时间，单位：秒
    public static int DEFAULT_SOCKET_TIMEOUT = 30 * 1000;

    private static HttpClient client;

    /**
     * Gets the HttpClient instance
     */
    public static HttpClient getClient() {
        if (client == null) {
            client = makeDefaultClient();
        }
        return client;
    }

    /**
     * 默认的Http Client实现
     *
     * @return Http Client实现
     */
    private static HttpClient makeDefaultClient() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

        PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        // Increase max connections for localhost:80 to 50
        HttpHost localhost = new HttpHost("locahost", 80);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        HttpClient client = new DefaultHttpClient(cm);
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, DEFAULT_CONNECTION_TIMEOUT);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);

        return client;
    }
}
