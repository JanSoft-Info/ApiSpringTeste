package br.com.jansoftinfo.apiteste.adapter.utils.enums;

public enum ReceivableStatusEnum {
    ABERTO("A"), VENCIDO("V"), LIQUIDADO("L");

    private String value;

    ReceivableStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}