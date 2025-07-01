package com.search_service.repository;

import com.search_service.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Integer> {
    List<Flights> findByOriginAndDestination(String origin, String destination);
}
