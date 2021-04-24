package com.flights.services.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.flights.services.dto.Airport;
import com.flights.services.services.AirportService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdixit
 * @since 22-04-2021
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightResource.class)
public class FlightResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportService airportService;

    Airport mockAirpot= new Airport("BOM", "Mumbai", "Mumbai","123");

    @Test
    public void test_getAirports() throws Exception
    {
        List<Airport> arAirports=new ArrayList<>();
        arAirports.add(mockAirpot);
        Mockito.when(airportService.retrieveAirports()).thenReturn(arAirports);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api//airports").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }

    @Test
    public void test_getAirport() throws Exception
    {
        List<Airport> arAirports=new ArrayList<>();
        arAirports.add(mockAirpot);
        Mockito.when(airportService.getAirport("BOM")).thenReturn(mockAirpot);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/airports/BOM").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }

    @Test
    public void test_saveAirport() throws Exception
    {
        List<Airport> arAirports=new ArrayList<>();
        arAirports.add(mockAirpot);
        String exampleAirportJson = "{\"airportCode\":\"BOM\",\"airportName\":\"Mumbai\",\"cityName\":\"Mumbai\",\"coordinates\":\"123\"}";
        Mockito.doNothing().when(airportService).saveAirport(mockAirpot);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/api/airports").accept(
                MediaType.APPLICATION_JSON).content(exampleAirportJson);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }

    @Test
    public void test_deleteAirport() throws Exception
    {
        Mockito.doNothing().when(airportService).deleteAirport("BOM");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/api/airports/BOM").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
    }

    @Test
    public void test_updateAirport() throws Exception
    {
        Mockito.doNothing().when(airportService).updateAirport(mockAirpot);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                "/api/airports/BOM").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);

    }
}
