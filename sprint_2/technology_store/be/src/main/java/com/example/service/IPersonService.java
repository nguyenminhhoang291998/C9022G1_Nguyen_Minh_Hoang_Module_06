package com.example.service;

import com.example.model.Person;

public interface IPersonService {
    Person findPersonById(Long personId);
}
