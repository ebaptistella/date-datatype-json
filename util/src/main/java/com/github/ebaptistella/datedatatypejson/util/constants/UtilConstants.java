package com.github.ebaptistella.datedatatypejson.util.constants;

public class UtilConstants {

    public static final String PKG_BASE = "com.github.ebaptistella.datedatatypejson";
    public static final String ALL_BASE = PKG_BASE.concat(".*");

    public static final String SERVER_ADDR = "http://localhost:8080/date-datatype-json-server/";
    public static final String TRANSFER_DATA_CONTROLLER_ENDPOINT = "/transfer";

    public static final String DATE_FORMATTER = "yyyy-MM-dd";
    public static final String TIME_FORMATTER = "HH:mm:ss.SSS";
    public static final String DATETIME_FORMATTER = DATE_FORMATTER.concat(" ").concat(TIME_FORMATTER);
    public static final String ZONEID = "America/Sao_Paulo";

    public static final String PRM_DATETIME = "dateTime";
    public static final String PRM_FORMAT = "format";
    public static final String PRM_ZONEID = "zoneID";

    private UtilConstants() {
    }

}
