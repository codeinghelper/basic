package com.github.codeinghelper.auth;

import java.lang.annotation.*;

/**
 * @author ：frank
 * @date ：Created in 2020/8/7 10:47
 * @description ：
 * @modified By：
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionRight {

    String actionCode() default " ";

    boolean require() default true;


}
