package com.onboard.domain.model;

import java.util.List;

import com.google.common.collect.Lists;

public enum IterationItemStatus {
    TODO("todo"), INPROGESS("inprogress"), FIXED("fixed"), APPROVED("approved"), REVIEWED("reviewed"), VERIFIED("verified"), CLOSED(
            "closed");

    private String status;

    private IterationItemStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return this.status;
    }

    public static List<String> getDefaultTodoStatus() {
        return Lists.newArrayList(TODO.getValue(), INPROGESS.getValue(), CLOSED.getValue());
    }

}
