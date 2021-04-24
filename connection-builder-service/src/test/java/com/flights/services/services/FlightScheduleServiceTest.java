package com.flights.services.services;

import com.flights.services.dto.Connections;
import com.flights.services.dto.FlightSchedule;
import com.flights.services.repository.FlightScheduleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author sdixit
 * @since 22-04-2021
 */
public class FlightScheduleServiceTest {

    @Mock
    private FlightScheduleRepository flightScheduleRepository;

    FlightScheduleService flightScheduleService;

    @Before
    public void setUp() {
        flightScheduleRepository = mock(FlightScheduleRepository.class);
        flightScheduleService = new FlightScheduleServiceImpl();
        ((FlightScheduleServiceImpl) flightScheduleService).setFlightScheduleRepository(flightScheduleRepository);

    }

    @Test
    public void test_retrieveFlightSchedules() {
        List<FlightSchedule> flightSchedules = getFlightScheduleTestData();
        when(flightScheduleRepository.findAll()).thenReturn(flightSchedules);
        Connections connections = flightScheduleService.retrieveFlightSchedules("BOM", "DXB");

        Assert.assertNotNull(connections);
        Assert.assertEquals("Number of available flights", 2, connections.getConnectionData().size());
    }

    private List<FlightSchedule> getFlightScheduleTestData() {
        List<FlightSchedule> flightSchedules = new ArrayList<>();
        FlightSchedule flightSchedule = new FlightSchedule("123", "BOM", "DXB", Time.valueOf("08:00:00"), Time.valueOf("09:30:00"));
        FlightSchedule flightSchedule2 = new FlightSchedule("210", "BOM", "DXB", Time.valueOf("08:00:00"), Time.valueOf("20:00:00"));
        FlightSchedule flightSchedule1 = new FlightSchedule("201", "DXB", "JFK", Time.valueOf("11:59:00"), Time.valueOf("11:59:00"));
        FlightSchedule flightSchedule3 = new FlightSchedule("201", "DXB", "JFK", Time.valueOf("2:50:00"), Time.valueOf("11:59:00"));
        flightSchedules.add(flightSchedule);
        flightSchedules.add(flightSchedule1);
        flightSchedules.add(flightSchedule2);
        flightSchedules.add(flightSchedule3);


        return flightSchedules;
    }
}
