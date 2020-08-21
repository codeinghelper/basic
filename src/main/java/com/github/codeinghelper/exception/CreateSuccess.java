/**
 * @author frank
 * @version 1.0.0
 * @ClassName UnifyResponse.java
 * @Description TODO
 * @createTime 2020年08月01日 18:35:00
 */
package com.github.codeinghelper.exception;


import com.github.codeinghelper.exception.http.HttpException;

public class CreateSuccess extends HttpException {
    public CreateSuccess(int code){
        this.httpStatusCode = 201;
        this.code = code;
    }
//    201 202 204
}
