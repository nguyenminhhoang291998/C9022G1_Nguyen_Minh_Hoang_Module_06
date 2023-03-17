package com.example.service;

import com.example.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICoachService {
    Page<Coach> findAll(Pageable pageable);

    boolean update(Coach coach);
    boolean delete(int id);

    Coach findById(int id);

    boolean save(Coach coach);
}
