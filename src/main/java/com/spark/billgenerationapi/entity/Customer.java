package com.spark.billgenerationapi.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

    private String customerId;
    private String posId;
    private String orderId;
    private Float totalCost;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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

    public Customer(String customerId, String posId, String orderId, Float totalCost) {
        this.customerId = customerId;
        this.posId = posId;
        this.orderId = orderId;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", posId='" + posId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
