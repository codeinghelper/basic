package com.github.codeinghelper.annotation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: lizeze
 * @CreateTime: 2020-08-04 22:05
 * @Description: ${Description}
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullValidator.class)
public @interface NotNull {

    String message() default "require not null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
