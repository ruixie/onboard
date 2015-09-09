package com.onboard.domain.model;

public enum TodoType {

    TASK("task"), STORY("story"), BUG("bug"), NONE("none");

    private String type;

    private TodoType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }

}
