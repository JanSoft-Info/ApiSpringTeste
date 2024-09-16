package br.com.jansoftinfo.apiteste.commons.enums;

public enum TitleStatusEnum {
    ABERTO("A"), VENCIDO("V"), LIQUIDADO("L");

    private String value;

    TitleStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}