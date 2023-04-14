package com.example.service.impl;

import com.example.model.Oder;
import com.example.repository.IOderRepository;
import com.example.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository oderRepository;
    @Override
    public Page<Oder> getAll(String name,String oderDate,Pageable pageable) {
        return oderRepository.getAll(name, oderDate, pageable);
    }
}
