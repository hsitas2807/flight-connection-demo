package com.flights.services.controller;

import com.flights.services.dto.Connections;
import com.flights.services.dto.FlightSchedule;
import com.flights.services.services.FlightScheduleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdixit
 * @since 22-04-2021
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightConnectionResource.class)
public class FlightConnectionResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightScheduleService flightScheduleService;

    FlightSchedule mockFlightSchedule= new FlightSchedule();

    @Test
    public void test_getAirports() throws Exception
    {
        List<FlightSchedule> flightScheduleList=new ArrayList<>();
        flightScheduleList.add(mockFlightSchedule);
        Connections connections=new Connections();
        Mockito.when(flightScheduleService.retrieveFlightSchedules("BOM","JXB")).thenReturn(connections);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api//flightconnections").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }

}
