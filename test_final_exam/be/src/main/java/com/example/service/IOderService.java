package com.example.service;

import com.example.model.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOderService {
    Page<Oder> getAll(String name,String oderDate,Pageable pageable);
}
