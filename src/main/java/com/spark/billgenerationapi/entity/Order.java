package com.spark.billgenerationapi.entity;

import com.spark.billgenerationapi.dto.Item;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("order")
public class Order {
    private int orderId;
    private List<Item> items;
    private Float totalCost;
    private String customerId;
    private String posId;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public Order(int orderId, List<Item> items, Float totalCost, String customerId, String posId,Date date) {
        this.orderId = orderId;
        this.items = items;
        this.totalCost = totalCost;
        this.customerId = customerId;
        this.posId = posId;
        this.date=date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId='" + orderId + '\'' +
                ", items=" + items +
                ", totalCost=" + totalCost +
                ", customerId='" + customerId + '\'' +
                ", posId='" + posId + '\'' +
                ",date='"+date +'\'' +
                '}';
    }
}
