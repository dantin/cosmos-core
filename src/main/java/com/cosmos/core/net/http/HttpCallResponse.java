package com.cosmos.core.net.http;

import com.cosmos.core.net.CallResponse;

/**
 * HTTP请求响应对象
 *
 * @author David
 */
public class HttpCallResponse extends CallResponse {

    /** HTTP状态码 */
    public int statusCode;

    public HttpCallResponse() {
        super();
    }

    /**
     * Constructs a new HttpResponse with the specified statusCode and response.
     *
     * @param statusCode
     *            http status code
     * @param response
     *            http reponse body
     */
    public HttpCallResponse(int statusCode, String response) {
        super(response);
        this.statusCode = statusCode;
    }

    /**
     * Construct a new HttpResponse with the the specified statusCode and exception.
     *
     * @param statusCode
     *            the http status code
     * @param e
     *            any exception resulting from dealing the user's request.
     */
    public HttpCallResponse(int statusCode, Exception e) {
        super(e);
        this.statusCode = statusCode;
    }

    /**
     * Construct a new CallRet with the specified ret, behaves like copy
     * constructor.
     *
     * @param response
     */
    public HttpCallResponse(HttpCallResponse response) {
        super(response.response, response.exception);
        this.statusCode = response.statusCode;
    }

    /**
     * Check whether response is OK
     *
     * @return {@code true} if successfully processed the user's request, otherwise {@code false}.
     */
    public boolean ok() {
        return this.statusCode / 100 == 2 && !super.isException();
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String toString() {
        if (this.exception != null) {
            return this.exception.getMessage();
        }
        if (this.response != null) {
            return this.response;
        }

        return String.valueOf(this.statusCode);
    }
}
