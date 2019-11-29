package com.github.ebaptistella.datedatatypejson.server.controller.impl;

import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_DATETIME;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_FORMAT;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_ZONEID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.ebaptistella.datedatatypejson.dto.DataTransferDTO;
import com.github.ebaptistella.datedatatypejson.server.controller.TransferDataController;
import com.github.ebaptistella.datedatatypejson.server.service.TransferDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransferDataControllerImpl implements TransferDataController {

    @Autowired
    @Lazy
    private TransferDataService transferDataService;

    @Override
    public ResponseEntity<DataTransferDTO> getData(@RequestParam(value = PRM_DATETIME, required = true) String dateTime,
            @RequestParam(value = PRM_FORMAT, required = false) String format, @RequestParam(value = PRM_ZONEID, required = false) String zoneID) {

        log.debug("==>Input is: dateTime:{} format:{} zoneID:{}", dateTime, format, zoneID);
        return ResponseEntity.ok(transferDataService.populate(dateTime, format, zoneID));
    }
}
