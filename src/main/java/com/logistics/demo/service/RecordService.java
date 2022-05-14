package com.logistics.demo.service;

import com.logistics.demo.model.DeleteRecord;

import java.util.List;

public interface RecordService {

    /**
     * cancel a delete-record
     *
     * @return true for success, false for failure
     */
    public boolean cancelDeleteRecord(Integer recordId);

    /**
     * get all delete-records
     *
     * @return a list of delete-records
     */
    public List<DeleteRecord> getRecords();
}
