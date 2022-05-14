package com.logistics.demo.dao;

import com.logistics.demo.model.Item;

import java.util.List;

public interface ItemDAO {

    public List<Item> getAllItems();

    public List<Item> getExistedItems();

    public Item getItemById(Integer itemId);

    public void insertItem(Item item);

    public void updateItem(Item item);
}
