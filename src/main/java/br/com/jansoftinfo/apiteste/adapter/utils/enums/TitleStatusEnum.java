package br.com.jansoftinfo.apiteste.adapter.utils.enums;

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