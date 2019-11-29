package com.github.ebaptistella.datedatatypejson.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.github.ebaptistella.datedatatypejson.consumer.intercomm.TransferDataClient;
import com.github.ebaptistella.datedatatypejson.consumer.service.TransferDataService;
import com.github.ebaptistella.datedatatypejson.dto.DataTransferDTO;

@Service
public class TransferDataServiceImpl implements TransferDataService {

    @Autowired
    @Lazy
    private TransferDataClient transferDataClient;

    @Override
    public DataTransferDTO populate(String dateTime, String format, String zoneID) {
        return transferDataClient.getData(dateTime, format, zoneID);
    }

}
