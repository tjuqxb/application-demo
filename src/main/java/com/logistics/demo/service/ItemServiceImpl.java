package com.logistics.demo.service;
import com.logistics.demo.dao.DeleteRecordDAO;
import com.logistics.demo.dao.DeleteRecordDAOImpl;
import com.logistics.demo.dao.ItemDAO;
import com.logistics.demo.dao.ItemDAOImpl;
import com.logistics.demo.model.DeleteRecord;
import com.logistics.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    DeleteRecordDAO deleteRecordDAO;

    @Override
    public void addItem(Item item){

        itemDAO.insertItem(item);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean deleteItem(Integer itemId, String comment) throws RuntimeException{
        Item item;
        try {
            item = itemDAO.getItemById(itemId);
        } catch (Exception e) {
            return false;
        }
        if (item == null || item.getIs_deleted()) {
            return false;
        }
        item.setIs_deleted(true);
        itemDAO.updateItem(item);
        DeleteRecord deleteRecord = new DeleteRecord(null, itemId, comment, false, new Date(), new Date());
        deleteRecordDAO.insertRecord(deleteRecord);
        return true;
    }

    @Override
    public List<Item> getExistedItems() {
        return itemDAO.getExistedItems();
    }

    @Override
    public boolean updateItem(Item item) {
        try {
            itemDAO.updateItem(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
