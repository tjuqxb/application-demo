package com.logistics.demo.model;
import java.util.Date;

public class DeleteRecord {
    Integer rec_id;
    Integer item_id;
    String comment;
    Boolean is_cancelled;
    Date delete_date;
    Date delete_time;

    public DeleteRecord() {
    }

    public DeleteRecord(Integer item_id, String comment, Boolean is_cancelled, Date delete_date, Date delete_time) {
        this.item_id = item_id;
        this.comment = comment;
        this.is_cancelled = is_cancelled;
        this.delete_date = delete_date;
        this.delete_time = delete_time;
    }

    public DeleteRecord(Integer rec_id, Integer item_id, String comment, Boolean isCancelled, Date delete_date, Date delete_time) {
        this.rec_id = rec_id;
        this.item_id = item_id;
        this.comment = comment;
        this.is_cancelled = isCancelled;
        this.delete_date = delete_date;
        this.delete_time = delete_time;
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

    public Date getDelete_date() {
        return delete_date;
    }

    public Date getDelete_time() {
        return delete_time;
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

    public void setDelete_date(Date delete_date) {
        this.delete_date = delete_date;
    }

    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }
}
