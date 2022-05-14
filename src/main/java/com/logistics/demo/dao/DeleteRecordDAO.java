package com.logistics.demo.dao;

import com.logistics.demo.model.DeleteRecord;

import java.util.List;

public interface DeleteRecordDAO {
    public List<DeleteRecord> getAllRecentRecords();

    public void insertRecord(DeleteRecord record);

    public DeleteRecord getRecordById(Integer recordId);

    public void cancelRecordById(Integer recordId);
}
