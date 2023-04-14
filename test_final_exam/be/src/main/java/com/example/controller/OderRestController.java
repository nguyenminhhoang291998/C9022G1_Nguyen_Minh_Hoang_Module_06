package com.example.controller;

import com.example.model.Oder;
import com.example.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OderRestController {
    @Autowired
    private IOderService iOderService;

    @RequestMapping("/list")
    public ResponseEntity<?> getListOrder(@RequestParam(required = false,defaultValue = "0") int page,
                                          @RequestParam(required = false,defaultValue = "") String name,
                                          @RequestParam(required = false,defaultValue = "") @DateTimeFormat(pattern = "dd-MM-yyyy") String oderDate) {
        Page<Oder> oderPage;
        Pageable pageable = PageRequest.of(page,3);
        oderPage = iOderService.getAll(name,oderDate,pageable);
        if(oderPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(oderPage,HttpStatus.OK);
    }
}
