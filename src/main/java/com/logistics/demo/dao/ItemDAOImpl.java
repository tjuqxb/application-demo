package com.logistics.demo.dao;
import com.logistics.demo.Utils.BeanMapUtils;
import com.logistics.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class ItemDAOImpl implements ItemDAO{
    @Autowired
    JdbcTemplate jt;

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM items";
        List<Map<String, Object>> ret0 = jt.queryForList(sql);
        List<Item> ret = BeanMapUtils.mapsToBeans(ret0, Item.class);
        return ret;
    }

    @Override
    public List<Item> getExistedItems() {
        String sql = "SELECT * FROM items WHERE is_deleted = FALSE";
        List<Map<String, Object>> ret0 = jt.queryForList(sql);
        List<Item> ret = BeanMapUtils.mapsToBeans(ret0, Item.class);
        return ret;
    }

    @Override
    public Item getItemById(Integer itemId) {
        String sql = "SELECT * FROM items WHERE item_id = ?";
        Map<String, Object> ret0 = jt.queryForMap(sql, itemId);
        Item ret = BeanMapUtils.mapToBean(ret0, new Item());
        return ret;
    }

    @Override
    public void insertItem(Item item) {
        String sql = "INSERT INTO items (name, quantity, is_deleted) VALUES (?, ?, ?);";
        jt.update(sql, item.getName(), item.getQuantity(), item.getIs_deleted());
    }

    @Override
    public void updateItem(Item item) {
        String sql = "UPDATE items SET name = ?, quantity = ? WHERE item_id = ? AND is_deleted = FALSE";
        jt.update(sql, item.getName(), item.getQuantity(), item.getItem_id());
    }

}
