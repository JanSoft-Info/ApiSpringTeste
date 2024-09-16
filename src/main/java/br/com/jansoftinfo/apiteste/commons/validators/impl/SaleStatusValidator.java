package br.com.jansoftinfo.apiteste.commons.validators.impl;

import br.com.jansoftinfo.apiteste.commons.enums.CustomerTypeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SaleStatusValidator implements ConstraintValidator<br.com.jansoftinfo.apiteste.commons.validators.SaleStatusValidator, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (CustomerTypeEnum e : CustomerTypeEnum.values()) {
            if (e.getValue().equals(s)) return true;
        }

        return false;
    }
}
