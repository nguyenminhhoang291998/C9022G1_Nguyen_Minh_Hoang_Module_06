package com.example.controller;

import com.example.model.CoachType;
import com.example.model.Location;
import com.example.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("location")
public class LocationRestController {
    @Autowired
    private ILocationService locationService;
    @GetMapping("getAll")
    public ResponseEntity<List<Location>> getListCoachType() {
        List<Location> locationList = locationService.findAll();
        if(locationList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationList,HttpStatus.OK);
    }
}
