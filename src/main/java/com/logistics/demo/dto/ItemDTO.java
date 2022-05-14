package com.logistics.demo.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ItemDTO {
    Integer item_id;

    @NotNull
    String name;

    @NotNull
    @Min(1)
    Integer quantity;

    Boolean is_deleted;

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
}
