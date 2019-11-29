package com.github.ebaptistella.datedatatypejson.consumer.intercomm;

import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_DATETIME;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_FORMAT;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_ZONEID;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.SERVER_ADDR;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.TRANSFER_DATA_CONTROLLER_ENDPOINT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.ebaptistella.datedatatypejson.consumer.config.FeignConfiguration;
import com.github.ebaptistella.datedatatypejson.dto.DataTransferDTO;

@FeignClient(name = "server", url = SERVER_ADDR, configuration = FeignConfiguration.class)
public interface TransferDataClient {

    @GetMapping(value = TRANSFER_DATA_CONTROLLER_ENDPOINT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public abstract DataTransferDTO getData(@RequestParam(value = PRM_DATETIME, required = true) String dateTime,
            @RequestParam(value = PRM_FORMAT, required = false) String format, @RequestParam(value = PRM_ZONEID, required = false) String zoneID);
}
