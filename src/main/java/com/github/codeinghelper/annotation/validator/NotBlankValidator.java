package com.github.codeinghelper.annotation.validator;


import com.github.codeinghelper.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: lizeze
 * @CreateTime: 2020-08-04 21:50
 * @Description: ${Description}
 */
public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {
    @Override
    public void initialize(NotBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !StringUtil.isEmptyOrNull(s);
    }
}
