package com.flights.services.repository;


import com.flights.services.dto.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sdixit
 * @since 21-04-2021
 */
@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {
}
