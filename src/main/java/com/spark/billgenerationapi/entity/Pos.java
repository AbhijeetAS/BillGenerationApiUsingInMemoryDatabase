package com.spark.billgenerationapi.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pos {

    private String posId;
    private String orderId;
    private Float totalCost;
    private String customerId;

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Pos(String posId, String orderId, Float totalCost, String customerId) {
        this.posId = posId;
        this.orderId = orderId;
        this.totalCost = totalCost;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Pos{" +
                "posId='" + posId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", totalCost=" + totalCost +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

