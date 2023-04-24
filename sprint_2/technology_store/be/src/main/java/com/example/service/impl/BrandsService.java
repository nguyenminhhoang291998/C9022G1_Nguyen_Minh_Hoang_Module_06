package com.example.service.impl;

import com.example.model.Brands;
import com.example.repository.IBrandsRepository;
import com.example.service.IBrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandsService implements IBrandsService {
    @Autowired
    private IBrandsRepository iBrandsRepository;
    @Override
    public List<Brands> findAll() {
        return iBrandsRepository.findAll();
    }
}
