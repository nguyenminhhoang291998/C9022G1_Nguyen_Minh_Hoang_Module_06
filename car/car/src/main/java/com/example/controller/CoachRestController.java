package com.example.controller;

import com.example.dto.CoachDto;
import com.example.model.Coach;
import com.example.service.ICoachService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("coach")
public class CoachRestController {
    @Autowired
    private ICoachService coachService;

    @GetMapping("getAll")
    public ResponseEntity<Page<Coach>> getListCoach() {
        Page<Coach> coaches = coachService.findAll(PageRequest.of(0,10));
        if(coaches.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coaches,HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Coach> findById(@PathVariable int id) {
        Coach coach = coachService.findById(id);
        if(coach == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coach,HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Boolean> save(@RequestBody CoachDto coachDto) {
        Coach coach = new Coach();
        BeanUtils.copyProperties(coachDto,coach);
        boolean result = coachService.save(coach);
        if(!result){
            return new ResponseEntity<>(false,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Boolean> update(@RequestBody CoachDto coachDto) {
        Coach coach = new Coach();
        BeanUtils.copyProperties(coachDto,coach);
        boolean result = coachService.update(coach);
        if(!result){
            return new ResponseEntity<>(false,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean result = coachService.delete(id);
        if(!result){
            return new ResponseEntity<>(false,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
