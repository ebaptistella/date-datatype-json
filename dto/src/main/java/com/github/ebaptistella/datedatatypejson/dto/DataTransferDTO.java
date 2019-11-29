package com.github.ebaptistella.datedatatypejson.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import lombok.Data;

@Data
public class DataTransferDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime valueLocalDateTime;
    private LocalDate valueLocalDate;
    private LocalTime valueLocalTime;
    private Date valueDate;
}
