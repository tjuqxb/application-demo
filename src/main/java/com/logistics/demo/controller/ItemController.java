package com.logistics.demo.controller;
import com.logistics.demo.dto.DeleteRecordDTO;
import com.logistics.demo.dto.ItemDTO;
import com.logistics.demo.model.Item;
import com.logistics.demo.service.ItemService;
import com.logistics.demo.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = {"*"}, maxAge = 3600L)
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> getItems() {
        return new ResponseEntity<>(itemService.getExistedItems(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addItem(@RequestBody @Validated ItemDTO data) {
        String name = data.getName();
        Integer quantity = data.getQuantity();
        itemService.addItem(new Item(null, name, quantity, false));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value= "/edit")
    public ResponseEntity<?> editItem(@RequestBody @Validated ItemDTO data) {
        Integer item_id = data.getItem_id();
        Boolean is_deleted = data.getIs_deleted();
        if (item_id == null) {
            return new ResponseEntity<>("need an item id",HttpStatus.BAD_REQUEST);
        }
        if (item_id < 1) {
            return new ResponseEntity<>("wrong item id",HttpStatus.NOT_FOUND);
        }
        if (is_deleted == null || is_deleted) {
            return new ResponseEntity<>("wrong item status",HttpStatus.NOT_FOUND);
        }
        if (!itemService.updateItem(new Item(item_id, data.getName(), data.getQuantity(), false))) {
            return new ResponseEntity<>("wrong item id or wrong status",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> deleteItem(@RequestBody @Validated DeleteRecordDTO data) {
        Integer item_id = data.getItem_id();
        String comment = data.getComment();
        if (!itemService.deleteItem(item_id, comment)) {
            return new ResponseEntity<>("wrong item id",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
