package com.github.codeinghelper.annotation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: lizeze
 * @CreateTime: 2020-08-04 21:48
 * @Description: ${Description}
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankValidator.class)
public @interface NotBlank {

    String message() default "字符串不能为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
