package com.example.service.impl;

import com.example.model.Coach;
import com.example.model.CoachType;
import com.example.repository.ICoachRepository;
import com.example.repository.ICoachTypeRepository;
import com.example.service.ICoachService;
import com.example.service.ICoachTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoachTypeService implements ICoachTypeService {
    @Autowired
    private ICoachTypeRepository coachTypeRepository;

    @Override
    public List<CoachType> findAll() {
        return coachTypeRepository.findAll();
    }
}
