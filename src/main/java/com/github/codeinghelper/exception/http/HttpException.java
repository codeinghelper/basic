package com.github.codeinghelper.exception.http;

/**
 * @author zeze.li
 * @version 1.0.0
 * @ClassName HttpException.java
 * @Description TODO
 * @createTime 2020年08月01日 18:38:00
 */
public class HttpException extends RuntimeException {

    protected Integer code;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    protected Integer httpStatusCode = 500;
}
