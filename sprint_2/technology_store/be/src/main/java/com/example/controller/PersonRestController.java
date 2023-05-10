package com.example.controller;

import com.example.model.Brands;
import com.example.model.Person;
import com.example.security_authentication.jwt.JwtFilter;
import com.example.security_authentication.jwt.JwtUtility;
import com.example.service.IAccountService;
import com.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class PersonRestController {
    @Autowired
    private IPersonService iPersonService;

    @Autowired
    private JwtUtility jwtUtility;

    @GetMapping("/person-information")
    public ResponseEntity<Person> getInformation(HttpServletRequest request) {
        Long personId = getPersonIdFromToken(request);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = iPersonService.findPersonById(personId);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    private Long getPersonIdFromToken(HttpServletRequest request) {
        String jwt = JwtFilter.parseJwt(request);
        if (jwt != null && jwtUtility.validateJwtToken(jwt)) {
            return jwtUtility.getIdFromJwtToken(jwt);
        }
        return null;
    }

}
