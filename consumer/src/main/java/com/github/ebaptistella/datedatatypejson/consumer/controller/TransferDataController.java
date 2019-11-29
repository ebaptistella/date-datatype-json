package com.github.ebaptistella.datedatatypejson.consumer.controller;

import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.TRANSFER_DATA_CONTROLLER_ENDPOINT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.ebaptistella.datedatatypejson.dto.DataTransferDTO;

@RequestMapping(value = TRANSFER_DATA_CONTROLLER_ENDPOINT, consumes = { APPLICATION_JSON_VALUE }, produces = { APPLICATION_JSON_VALUE })
public interface TransferDataController {

    @GetMapping
    public abstract ResponseEntity<DataTransferDTO> getData(String dateTime, String format, String zoneID);
}
