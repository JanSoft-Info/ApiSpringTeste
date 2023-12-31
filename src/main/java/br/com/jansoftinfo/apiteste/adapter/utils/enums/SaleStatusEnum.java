package br.com.jansoftinfo.apiteste.adapter.utils.enums;

public enum SaleStatusEnum {
    ABERTA("A"), FECHADA("F");

    private String value;

    SaleStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}