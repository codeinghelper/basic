package com.github.codeinghelper.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: frank
 * @CreateTime: 2020-08-04 22:07
 * @Description: ${Description}
 */
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {
    @Override
    public void initialize(NotNull notNull) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return null != o;
    }
}
