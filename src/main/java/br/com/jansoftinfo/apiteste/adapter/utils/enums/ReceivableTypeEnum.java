package br.com.jansoftinfo.apiteste.adapter.utils.enums;

import lombok.Getter;

@Getter
public enum ReceivableTypeEnum {
    BOLETO("B"), CARTAO("C"), DUPLICATA("D"), PIX("P");

    private String value;

    ReceivableTypeEnum(String value) {
        this.value = value;
    }
}
