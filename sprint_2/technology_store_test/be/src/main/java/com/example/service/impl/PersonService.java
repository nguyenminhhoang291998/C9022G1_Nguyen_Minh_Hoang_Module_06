package com.example.service.impl;

import com.example.model.Person;
import com.example.repository.IPersonRepository;
import com.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository iPersonRepository;
    @Override
    public Person findPersonById(Long personId) {
        return iPersonRepository.findById(personId).orElse(null);
    }
}
