package com.github.codeinghelper.annotation.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: frank
 * @CreateTime: 2020-08-04 22:27
 * @Description: ${Description}
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankValidator.class)
public @interface NotEmpty {
}
