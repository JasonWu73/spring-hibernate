package org.example.springhibernate.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourseCode {

    String[] values() default {"LUV"};

    String message() default "必需以指定字符串开头";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
