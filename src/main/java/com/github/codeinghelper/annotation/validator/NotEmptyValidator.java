package com.github.codeinghelper.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: lizeze
 * @CreateTime: 2020-08-04 22:28
 * @Description: ${Description}
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object> {
    @Override
    public void initialize(NotEmpty notEmpty) {

    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {

        return true;
    }
}
