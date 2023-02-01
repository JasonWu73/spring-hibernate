package org.example.springhibernate.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] codePrefixes;

    @Override
    public void initialize(CourseCode courseCode) {
        this.codePrefixes = courseCode.values();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        if (code == null) return true;

        for (String codePrefix : codePrefixes) {
            if (code.startsWith(codePrefix)) return true;
        }

        return false;
    }
}
