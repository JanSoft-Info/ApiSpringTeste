package br.com.jansoftinfo.apiteste.adapter.utils.enums;

public enum OperationStatusEnum {
    ABERTA("A"), FECHADA("F");

    private String value;

    OperationStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}