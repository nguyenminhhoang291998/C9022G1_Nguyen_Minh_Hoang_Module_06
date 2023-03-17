package com.example.controller;

import com.example.model.Coach;
import com.example.model.CoachType;
import com.example.service.ICoachService;
import com.example.service.ICoachTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("coachType")
public class CoachTypeRestController {
    @Autowired
    private ICoachTypeService coachTypeService;

    @GetMapping("getAll")
    public ResponseEntity<List<CoachType>> getListCoachType() {
        List<CoachType> coachTypeList = coachTypeService.findAll();
        if(coachTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coachTypeList,HttpStatus.OK);
    }
}
