package com.logistics.demo.controller;

import com.logistics.demo.service.RecordService;
import com.logistics.demo.service.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/records")
@CrossOrigin(origins = {"*"}, maxAge = 3600L)
public class DeleteRecordController {
    @Autowired
    RecordService recordService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> getDeleteRecords() {
        return new ResponseEntity<>(recordService.getRecords(), HttpStatus.OK);
    }

    @PutMapping(value = "/cancel/{recordId}")
    public ResponseEntity<?> cancelRecord(@PathVariable @Min(1) Integer recordId) {
        if (!recordService.cancelDeleteRecord(recordId)) {
            return new ResponseEntity<>("wrong record id",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
