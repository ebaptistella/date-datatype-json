package com.github.ebaptistella.datedatatypejson.server.controller;

import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.DATETIME_FORMATTER;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.DATE_FORMATTER;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_DATETIME;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_FORMAT;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PRM_ZONEID;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.TRANSFER_DATA_CONTROLLER_ENDPOINT;
import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.ZONEID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TransferDataControllerTest {

    private static final String FIX_DATE = "2019-11-28";
    private static final String FIX_TIME = "16:51:35.312";
    private static final String FIX_DATETIME = FIX_DATE.concat(" ").concat(FIX_TIME);
    private static final String VALUE_LOCALDATETIME = FIX_DATE.concat("T").concat(FIX_TIME);
    private static final String VALUE_LOCALDATE = FIX_DATE;
    private static final String VALUE_LOCALTIME = FIX_TIME;
    private static final String VALUE_DATE = FIX_DATE.concat("T19:51:35.312+0000");
    private static final String VALUE_DATE_GMT_3 = FIX_DATE.concat("T03:00:00.000+0000");

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getDataWithoutFormatAndZoneID() throws Exception {
        mockMvc.perform(get(TRANSFER_DATA_CONTROLLER_ENDPOINT).param(PRM_DATETIME, FIX_DATETIME).accept(APPLICATION_JSON_VALUE)
                .contentType(APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valueLocalDateTime").value(VALUE_LOCALDATETIME)).andExpect(jsonPath("$.valueLocalDate").value(VALUE_LOCALDATE))
                .andExpect(jsonPath("$.valueLocalTime").value(VALUE_LOCALTIME)).andExpect(jsonPath("$.valueDate").value(VALUE_DATE)).andReturn();
    }

    @Test
    public void getDataWithFormat() throws Exception {
        mockMvc.perform(get(TRANSFER_DATA_CONTROLLER_ENDPOINT).param(PRM_DATETIME, FIX_DATETIME).param(PRM_FORMAT, DATETIME_FORMATTER)
                .accept(APPLICATION_JSON_VALUE).contentType(APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valueLocalDateTime").value(VALUE_LOCALDATETIME)).andExpect(jsonPath("$.valueLocalDate").value(VALUE_LOCALDATE))
                .andExpect(jsonPath("$.valueLocalTime").value(VALUE_LOCALTIME)).andExpect(jsonPath("$.valueDate").value(VALUE_DATE)).andReturn();
    }

    @Test
    public void getDataWithFormatAndZoneID() throws Exception {
        mockMvc.perform(get(TRANSFER_DATA_CONTROLLER_ENDPOINT).param(PRM_DATETIME, FIX_DATETIME).param(PRM_FORMAT, DATETIME_FORMATTER)
                .param(PRM_ZONEID, ZONEID).accept(APPLICATION_JSON_VALUE).contentType(APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.valueLocalDateTime").value(VALUE_LOCALDATETIME))
                .andExpect(jsonPath("$.valueLocalDate").value(VALUE_LOCALDATE)).andExpect(jsonPath("$.valueLocalTime").value(VALUE_LOCALTIME))
                .andExpect(jsonPath("$.valueDate").value(VALUE_DATE)).andReturn();
    }

    @Test
    public void getDataWithFormatDate() throws Exception {
        mockMvc.perform(get(TRANSFER_DATA_CONTROLLER_ENDPOINT).param(PRM_DATETIME, FIX_DATETIME).param(PRM_FORMAT, DATE_FORMATTER)
                .accept(APPLICATION_JSON_VALUE).contentType(APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.valueLocalDateTime").isEmpty()).andExpect(jsonPath("$.valueLocalDate").value(VALUE_LOCALDATE))
                .andExpect(jsonPath("$.valueLocalTime").value(VALUE_LOCALTIME)).andExpect(jsonPath("$.valueDate").value(VALUE_DATE_GMT_3))
                .andReturn();
    }
}
