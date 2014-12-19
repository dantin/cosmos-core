package com.cosmos.core.net.http;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * 处理HTTP协议的客户端
 *
 * @author David
 */
public class HttpAgent {

    private final static  String HEADER_AGENT = "User-Agent";

    private int ERROR_CODE = 0;

    public static HttpPost newPost(String url){
        HttpPost postMethod = new HttpPost(url);
        postMethod.setHeader(HEADER_AGENT, getUserAgent());
        return postMethod;
    }

    public void setAuth(HttpPost post) {

    }

    private static String getUserAgent(){
        String javaVersion = "Java/" + System.getProperty("java.version");
        String os = System.getProperty("os.name") + " "
                +  System.getProperty("os.arch") + " " + System.getProperty("os.version");
        String sdk = "QiniuJava/" + "1.0";
        return sdk + " (" + os +") " + javaVersion;
    }

    /**
     *
     * @param url
     * @return
     */
    public HttpCallResponse get(String url) {
        HttpClient client = Http.getClient();
        HttpGet getMethod = new HttpGet(url);
        try {
            HttpResponse response = client.execute(getMethod);
            return handleResult(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpCallResponse(ERROR_CODE, e);
        }
    }

    /**
     * Sends a http post request to the specified url.
     *
     * @param url
     *            the request url
     * @return A general response
     */
    public HttpCallResponse post(String url) {
        HttpClient client = Http.getClient();
        HttpPost postMethod = newPost(url);
        try {
            setAuth(postMethod);
            HttpResponse response = client.execute(postMethod);
            return handleResult(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpCallResponse(ERROR_CODE, e);
        }
    }

    /**
     * Sends a http request to the specified url with the specified entity.
     * @param url
     * @param nvps
     * @return A general response
     */
    public HttpCallResponse post(String url, List<NameValuePair> nvps) {
        HttpClient client = Http.getClient();
        HttpPost postMethod = newPost(url);
        try {
            StringEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
            entity.setContentType("application/x-www-form-urlencoded");
            postMethod.setEntity(entity);
            setAuth(postMethod);
            HttpResponse response = client.execute(postMethod);

            return handleResult(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpCallResponse(ERROR_CODE, e);
        }
    }

    /**
     * Sends a http request to the specified url with the specified entity.
     * @param url
     * @param entity
     * @return A general response
     */
    public HttpCallResponse post(String url, AbstractHttpEntity entity) {
        HttpClient client = Http.getClient();
        HttpPost postMethod = newPost(url);
        postMethod.setEntity(entity);

        try {
            setAuth(postMethod);
            HttpResponse response = client.execute(postMethod);
            return handleResult(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpCallResponse(ERROR_CODE, e);
        }
    }

    /**
     *
     * @param url
     *            the request url
     * @param contentType
     *            the request content type
     * @param body
     *            the request body
     * @return A general response
     */
    public HttpCallResponse post(String url, String contentType, byte[] body) {
        ByteArrayEntity entity = new ByteArrayEntity(body);

        if (contentType == null || contentType.isEmpty()) {
            contentType = "application/octet-stream";
        }
        entity.setContentType(contentType);
        return post(url, entity);
    }

    /**
     *
     * @param url
     * @param requestEntity
     * @return A general response format
     */
    public HttpCallResponse post(String url, MultipartEntity requestEntity) {
        HttpPost postMethod = newPost(url);
        postMethod.setEntity(requestEntity);
        HttpClient client = Http.getClient();

        try {
            HttpResponse response = client.execute(postMethod);
            return handleResult(response);
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpCallResponse(ERROR_CODE, e);
        }
    }

    private HttpCallResponse handleResult(HttpResponse response) {
        if (response == null || response.getStatusLine() == null) {
            return new HttpCallResponse(ERROR_CODE, "No response");
        }

        String responseBody;
        try {
            responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpCallResponse(ERROR_CODE, e);
        }

        StatusLine status = response.getStatusLine();
        int statusCode = (status == null) ? ERROR_CODE : status.getStatusCode();
        return new HttpCallResponse(statusCode, responseBody);
    }

}
