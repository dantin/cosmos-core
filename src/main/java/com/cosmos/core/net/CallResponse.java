package com.cosmos.core.net;

/**
 * 请求响应对象
 *
 * @author David
 */
public class CallResponse {

    /** 响应体 */
    public String response;

    /** 处理过程中的异常 */
    public Exception exception;

    public CallResponse() {
    }

    public CallResponse(String response) {
        this.response = response;
    }

    public CallResponse(Exception exception) {
        this.exception = exception;
    }

    public CallResponse(String response, Exception exception) {
        this.response = response;
        this.exception = exception;
    }

    public String getResponse() {
        return this.response;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean isException() {
        return this.exception != null;
    }
}
