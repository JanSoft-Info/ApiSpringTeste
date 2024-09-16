package br.com.jansoftinfo.apiteste.commons.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = br.com.jansoftinfo.apiteste.commons.validators.impl.CustomerTypeValidator.class)
@ReportAsSingleViolation
public @interface CustomerTypeValidator {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}
