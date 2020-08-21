package com.github.codeinghelper.annotation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: frank
 * @CreateTime: 2020-08-04 22:33
 * @Description: ${Description}
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {
    String message() default "长度最小为{0}最大为{1}";

    int max() default 32;

    int min() default 4;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
