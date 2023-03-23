package com.spark.billgenerationapi.dto;

public enum Authority {

    READ_USER("read:user"),
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
