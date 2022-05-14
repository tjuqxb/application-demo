package com.logistics.demo.model;
import java.math.BigInteger;

public class DeleteRecord {
    Integer rec_id;
    Integer item_id;
    String comment;
    Boolean is_cancelled;
    Long timestamp;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public DeleteRecord() {
    }

    public DeleteRecord(Integer item_id, String comment, Boolean is_cancelled, Long timestamp) {
        this.item_id = item_id;
        this.comment = comment;
        this.is_cancelled = is_cancelled;
        this.timestamp = timestamp;
    }

    public DeleteRecord(Integer rec_id, Integer item_id, String comment, Boolean isCancelled, Long timestamp) {
        this.rec_id = rec_id;
        this.item_id = item_id;
        this.comment = comment;
        this.is_cancelled = isCancelled;
        this.timestamp = timestamp;
    }

    public Integer getRec_id() {
        return rec_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public String getComment() {
        return comment;
    }

    public Boolean getIs_cancelled() {
        return is_cancelled;
    }



    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIs_cancelled(Boolean isCancelled) {
        this.is_cancelled = isCancelled;
    }


}
