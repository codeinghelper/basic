package com.github.codeinghelper.annotation.validator;
import com.github.codeinghelper.util.StringUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;

/**
 * @BelongsProject: test
 * @BelongsPackage: com.example.demo.validator
 * @Author: frank
 * @CreateTime: 2020-08-04 22:37
 * @Description: ${Description}
 */
public class LengthValidator implements ConstraintValidator<Length, String> {

    int min;
    int max;
    String message = "";

    @Override
    public void initialize(Length constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
        message = MessageFormat.format(constraintAnnotation.message(), min, max);

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtil.isEmptyOrNull(s)) return false;
        return s.length() >= min && s.length() <= max;
    }
}
