package br.com.jansoftinfo.apiteste.adapter.utils.validators.impl;

import br.com.jansoftinfo.apiteste.adapter.utils.enums.CustomerTypeEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReceivableStatusValidator implements ConstraintValidator<br.com.jansoftinfo.apiteste.adapter.utils.validators.ReceivableStatusValidator, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (CustomerTypeEnum e : CustomerTypeEnum.values()) {
            if (e.getValue().equals(s)) return true;
        }

        return false;
    }
}
