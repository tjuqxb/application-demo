package com.logistics.demo.dto;
import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class DeleteRecordDTO {
    @NotNull
    @Min(1)
    Integer item_id;

    String comment;

    public Integer getItem_id() {
        return item_id;
    }

    public String getComment() {
        return comment;
    }
}
