package com.github.codeinghelper.response;

import com.github.codeinghelper.exception.CreateSuccess;

/**
 * @author frank
 * @version 1.0.0
 * @ClassName UnifyResponse.java
 * @Description API返回类
 * @createTime 2020年08月01日 18:35:00
 */
public class UnifyResponse {
    private int code;
    private String message;
    private Object data;
    private String request;

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }

    public static void createSuccess(int code) {
        throw new CreateSuccess(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
