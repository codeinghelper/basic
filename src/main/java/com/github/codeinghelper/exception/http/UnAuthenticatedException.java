/**
 * @author zeze.li
 * @version 1.0.0
 * @ClassName HttpException.java
 * @Description TODO
 * @createTime 2020年08月01日 18:38:00
 */
package com.github.codeinghelper.exception.http;

public class UnAuthenticatedException extends HttpException{
    public UnAuthenticatedException(int code){
        this.code = code;
        this.httpStatusCode = 401;
    }
}
