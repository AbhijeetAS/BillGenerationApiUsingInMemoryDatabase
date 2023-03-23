package com.spark.billgenerationapi.service.BillGenerate;

import com.spark.billgenerationapi.dto.Item;

import java.util.List;


public class Generate {
    private String customerId;
    private List<Item> item;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
    public Generate(String customerId, List<Item> item) {
        this.customerId = customerId;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Generate{" +
                "customerId='" + customerId + '\'' +
                ", item=" + item +
                '}';
    }

}
