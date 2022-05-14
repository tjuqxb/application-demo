package com.logistics.demo.service;

import com.logistics.demo.dao.DeleteRecordDAO;
import com.logistics.demo.dao.ItemDAOImpl;
import com.logistics.demo.model.DeleteRecord;
import com.logistics.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    ItemDAOImpl itemDAO;
    @Autowired
    DeleteRecordDAO deleteRecordDAO;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean cancelDeleteRecord(Integer recordId) {
        DeleteRecord deleteRecord;
        try {
            deleteRecord = deleteRecordDAO.getRecordById(recordId);
        } catch (Exception e) {
            return false;
        }
        if (deleteRecord == null || deleteRecord.getIs_cancelled()) {
            return false;
        }
        Integer itemId = deleteRecord.getItem_id();
        Item item = itemDAO.getItemById(itemId);
        if (!item.getIs_deleted()) {
            return false;
        }
        item.setIs_deleted(false);
        itemDAO.updateItem(item);
        deleteRecordDAO.cancelRecordById(recordId);
        return true;
    }

    @Override
    public List<DeleteRecord> getRecords() {
        return deleteRecordDAO.getAllRecords();
    }
}
