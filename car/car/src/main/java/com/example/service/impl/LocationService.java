package com.example.service.impl;

import com.example.model.Location;
import com.example.repository.ILocationRepository;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
