/**
 * @author zeze.li
 * @version 1.0.0
 * @ClassName HttpException.java
 * @Description TODO
 * @createTime 2020年08月01日 18:38:00
 */
package com.github.codeinghelper.exception.http;

public class NotFoundException extends HttpException {
    public NotFoundException(int code){
        this.httpStatusCode = 404;
        this.code = code;
    }
}
