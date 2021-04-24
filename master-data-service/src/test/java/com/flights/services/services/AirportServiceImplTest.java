package com.flights.services.services;

import com.flights.services.dto.Airport;
import com.flights.services.repository.AirportRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

/**
 * @author sdixit
 * @since 21-04-2021
 */

public class AirportServiceImplTest {

    @Mock
    private AirportRepository airportRepository;

    AirportService airportService;

    @Before
    public void setUp()
    {
        airportRepository=mock(AirportRepository.class);
        airportService=new AirportServiceImpl();
        ((AirportServiceImpl) airportService).setAirportRepository(airportRepository);

    }


    @Test
    public void test_retrieveAirports() {

        when(airportRepository.findAll()).thenReturn(Arrays.asList(new Airport()));
        List<Airport> airportList= airportService.retrieveAirports();
        assertFalse(airportList.isEmpty());
        verify(airportRepository,times(1)).findAll();
    }

    @Test
    public void test_getAirport() {

        Airport airport=getAirportTestData();
        when(airportRepository.findAll()).thenReturn(Arrays.asList(airport));
        Airport result=airportService.getAirport("BOM");
        Assert.assertNotNull(result);

    }

    @Test
    public void test_saveAirport() {
        Airport airport=getAirportTestData();
        airportService.saveAirport(airport);
        verify(airportRepository,times(1)).save(any(Airport.class));
    }

    @Test
    public void test_deleteAirport() {
        Airport airport=getAirportTestData();
        when(airportRepository.findAll()).thenReturn(Arrays.asList(airport));
        doNothing().when(airportRepository).deleteById(anyLong());
        airportService.deleteAirport("BOM");
        verify(airportRepository,times(1)).deleteById(anyLong());
    }

    @Test
    public void test_updateAirport() {
        Airport airport=getAirportTestData();
        airportService.updateAirport(airport);
        verify(airportRepository,times(1)).save(anyObject());
    }

    private Airport getAirportTestData()
    {
        Airport airport=new Airport();
        airport.setId(1);
        airport.setAirportCode("BOM");
        airport.setAirportName("Mumbai Airport");
        return airport;
    }
}
