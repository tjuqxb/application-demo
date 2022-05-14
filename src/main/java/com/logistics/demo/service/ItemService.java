package com.logistics.demo.service;

import com.logistics.demo.model.Item;

import java.util.List;

public interface ItemService {

    /**
     * add an item, no item_id conflicts
     */
    public void addItem(Item item);

    /**
     * delete an item
     *
     * @return true for success, false for failure
     */
    public boolean deleteItem(Integer itemId, String comment);

    /**
     * get all undeleted items
     *
     * @return all undeleted items
     */
    public List<Item> getExistedItems();

    /**
     * update an item
     *
     * @return true for success, false for failure
     */
    public boolean updateItem(Item item);

}
