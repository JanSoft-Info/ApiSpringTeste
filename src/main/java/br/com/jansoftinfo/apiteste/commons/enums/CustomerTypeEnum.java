package br.com.jansoftinfo.apiteste.commons.enums;

public enum CustomerTypeEnum {
    FISICA("F"), JURIDICA("J");

    private String value;

    CustomerTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}