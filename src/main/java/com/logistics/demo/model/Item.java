package com.logistics.demo.model;

public class Item {
    Integer item_id;
    String name;
    Integer quantity;
    Boolean is_deleted;

    public Item() {
    }


    public Item(Integer item_id, String name, Integer quantity, Boolean is_deleted) {
        this.item_id = item_id;
        this.name = name;
        this.quantity = quantity;
        this.is_deleted = is_deleted;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
