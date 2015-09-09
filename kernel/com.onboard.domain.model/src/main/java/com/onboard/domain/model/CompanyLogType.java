package com.onboard.domain.model;

public enum CompanyLogType {

    SUCCESS(1), FAILED(2), CLOSED(3);

    private int type;

    private CompanyLogType(int type) {
        this.type = type;
    }

    public int getValue() {
        return type;
    }
}
