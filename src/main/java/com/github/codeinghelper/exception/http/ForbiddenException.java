/**
 * @author frank
 * @version 1.0.0
 * @ClassName HttpException.java
 * @Description TODO
 * @createTime 2020年08月01日 18:38:00
 */
package com.github.codeinghelper.exception.http;

public class ForbiddenException extends HttpException {
    public ForbiddenException(int code) {
        this.code = code;

        this.httpStatusCode = 403;
    }
}
