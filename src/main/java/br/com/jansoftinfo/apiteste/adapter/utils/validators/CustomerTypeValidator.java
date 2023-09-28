package br.com.jansoftinfo.apiteste.adapter.utils.validators;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = br.com.jansoftinfo.apiteste.adapter.utils.validators.impl.CustomerTypeValidator.class)
@ReportAsSingleViolation
public @interface CustomerTypeValidator {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}
