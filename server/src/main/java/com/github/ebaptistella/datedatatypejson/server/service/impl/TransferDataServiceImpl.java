package com.github.ebaptistella.datedatatypejson.server.service.impl;

import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.DATETIME_FORMATTER;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.DATE_FORMATTER;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.TIME_FORMATTER;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.github.ebaptistella.datedatatypejson.dto.DataTransferDTO;
import com.github.ebaptistella.datedatatypejson.server.service.TransferDataService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransferDataServiceImpl implements TransferDataService {

    @Override
    public DataTransferDTO populate(String dateTime, String format, String zoneID) {
        DataTransferDTO dto = new DataTransferDTO();

        try {
            dto.setValueLocalDateTime(LocalDateTime.parse(dateTime, getFormatDateTimeFormatter(format)));
        } catch (Exception e) {
            log.error("==>Error parse LocalDateTime: {}", e);
        }

        try {
            dto.setValueLocalTime(LocalTime.parse(getTimeFromDateTime(dateTime), getFormatTimeFormatter(format)));
        } catch (Exception e) {
            log.error("==>Error parse LocalTime: {}", e);
        }

        try {
            dto.setValueLocalDate(LocalDate.parse(getDateFromDateTime(dateTime), getFormatDateFormatter(format)));
        } catch (Exception e) {
            log.error("==>Error parse LocalDate: {}", e);
        }

        try {
            dto.setValueDate(getFormatSimpleDateFormat(format).parse(dateTime));
        } catch (Exception e) {
            log.error("==>Error parse Date: {}", e);
        }

        log.debug("==>Output is: {}", dto);
        return dto;
    }

    private DateTimeFormatter getFormatDateFormatter(String format) {
        String[] aTimeFormat = DATE_FORMATTER.split(" ");
        if ((format != null) && (!format.isEmpty())) {
            aTimeFormat = format.split(" ");
        }

        return DateTimeFormatter.ofPattern(aTimeFormat[0]);
    }

    private String getDateFromDateTime(String dateTime) {
        return dateTime.split(" ")[0];
    }

    private String getTimeFromDateTime(String dateTime) {
        String[] aDateTime = dateTime.split(" ");
        if (aDateTime.length > 1) {
            return aDateTime[1];
        }

        return LocalTime.now().format(getFormatTimeFormatter(null));
    }

    private DateTimeFormatter getFormatDateTimeFormatter(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATETIME_FORMATTER);
        if ((format != null) && (!format.isEmpty())) {
            dtf = DateTimeFormatter.ofPattern(format);
        }

        return dtf;
    }

    private DateTimeFormatter getFormatTimeFormatter(String format) {
        String[] aTimeFormat = TIME_FORMATTER.split(" ");
        if ((format != null) && (!format.isEmpty())) {
            aTimeFormat = format.split(" ");
        }

        String timeFormat = TIME_FORMATTER;
        if (aTimeFormat.length > 1) {
            timeFormat = aTimeFormat[1];
        }

        return DateTimeFormatter.ofPattern(timeFormat);
    }

    private SimpleDateFormat getFormatSimpleDateFormat(String format) {
        SimpleDateFormat dtf = new SimpleDateFormat(DATETIME_FORMATTER);
        if ((format != null) && (!format.isEmpty())) {
            dtf = new SimpleDateFormat(format);
        }

        return dtf;
    }

}
