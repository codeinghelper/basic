/**
 * @author zeze.li
 * @version 1.0.0
 * @ClassName UnifyResponse.java
 * @Description TODO
 * @createTime 2020年08月01日 18:35:00
 */
package com.github.codeinghelper.exception;


import com.github.codeinghelper.exception.http.HttpException;

public class DeleteSuccess extends HttpException {
    public DeleteSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
    // 200 201 204 200
    // 200 201 200 200

    // Create：201 资源本身
    // Get: 200
    // Put: 200
    // Delete: 200
}
