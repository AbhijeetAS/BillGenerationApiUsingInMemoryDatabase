package com.spark.billgenerationapi.dto;

public class Item {

    private String itemName;
    private String price;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Item(String itemName, String price) {
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
