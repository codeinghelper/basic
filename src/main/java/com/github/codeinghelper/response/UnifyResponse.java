package com.github.codeinghelper.response;

import com.github.codeinghelper.exception.CreateSuccess;

import java.util.Date;

/**
 * @author frank
 * @version 1.0.0
 * @ClassName UnifyResponse.java
 * @Description API返回类
 * @createTime 2020年08月01日 18:35:00
 */
public class UnifyResponse<T> {
    private Date createTime;
    private T data;
    private ErrorCode errorCode;

    public UnifyResponse(T data) {
        this.data = data;
        this.createTime = new Date();
        this.errorCode = new ErrorCode(0, "成功");
    }

    public UnifyResponse(Integer code, String message) {

        this.createTime = new Date();
        this.errorCode = new ErrorCode(code, message);
    }

    public UnifyResponse() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
