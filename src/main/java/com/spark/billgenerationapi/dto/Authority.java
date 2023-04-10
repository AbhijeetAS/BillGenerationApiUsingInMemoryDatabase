package com.spark.billgenerationapi.dto;

public enum Authority {

    GET_EARN("get:earn"),
    WRITE_USER("write:user"),
    READ_ORDER("read:order"),
    WRITE_ORDER("write:order");

    private String permission;

    Authority(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
