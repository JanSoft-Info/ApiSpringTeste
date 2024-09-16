package br.com.jansoftinfo.apiteste.commons.enums;

import lombok.Getter;

@Getter
public enum TitleTypeEnum {
    BOLETO("B"), CARTAO("C"), DUPLICATA("D"), PIX("P");

    private String value;

    TitleTypeEnum(String value) {
        this.value = value;
    }
}
