package com.logistics.demo.dao;
import com.logistics.demo.Utils.BeanMapUtils;
import com.logistics.demo.model.DeleteRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class DeleteRecordDAOImpl implements DeleteRecordDAO {
    @Autowired
    JdbcTemplate jt;

    @Override
    public List<DeleteRecord> getAllRecords() {
        String sql = "SELECT * FROM delete_records ORDER BY rec_id DESC ";
        List<Map<String, Object>> ret0 = jt.queryForList(sql);
        List<DeleteRecord> ret = BeanMapUtils.mapsToBeans(ret0, DeleteRecord.class);
        return ret;
    }

    @Override
    public void insertRecord(DeleteRecord record) {
        String sql = "INSERT INTO delete_records (item_id, comment, is_cancelled, delete_date, delete_time) VALUES (?, ?, ?, ?, ?)";
        jt.update(sql, record.getItem_id(), record.getComment(), record.getIs_cancelled(), record.getDelete_date(), record.getDelete_time());
    }

    @Override
    public DeleteRecord getRecordById(Integer recordId) {
        String sql = "SELECT * FROM delete_records WHERE rec_id = ?";
        Map<String, Object> ret0 = jt.queryForMap(sql, recordId);
        DeleteRecord ret = BeanMapUtils.mapToBean(ret0, new DeleteRecord());
        return ret;
    }

    @Override
    public void cancelRecordById(Integer recordId) {
        String sql = "UPDATE delete_records SET is_cancelled = TRUE WHERE rec_id = ?";
        jt.update(sql, recordId);
    }

}
