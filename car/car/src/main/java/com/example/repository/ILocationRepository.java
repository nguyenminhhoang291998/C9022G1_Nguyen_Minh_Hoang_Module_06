package com.example.repository;

import com.example.model.CoachType;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "select * from location",nativeQuery = true)
    List<Location> findAll();
}
