package com.flights.services.repository;


import com.flights.services.dto.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sdixit
 * @since 21-04-2021
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
