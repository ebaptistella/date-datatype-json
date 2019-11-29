package com.github.ebaptistella.datedatatypejson.consumer.service;

import com.github.ebaptistella.datedatatypejson.dto.DataTransferDTO;

public interface TransferDataService {

    public abstract DataTransferDTO populate(String dateTime, String format, String zoneID);
}
