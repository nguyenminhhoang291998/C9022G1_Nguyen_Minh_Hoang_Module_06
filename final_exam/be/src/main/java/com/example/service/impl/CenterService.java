package com.example.service.impl;

import com.example.dto.ICenterDTO;
import com.example.model.Center;
import com.example.repository.ICenterRepository;
import com.example.service.ICenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CenterService implements ICenterService {
    @Autowired
    private ICenterRepository centerRepository;
    @Override
    public Page<ICenterDTO> findAllCenter(String nameCenter,  String nameAdmin, Pageable pageable){
        return centerRepository.findAllCenter(nameCenter, nameAdmin, pageable);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            centerRepository.deleteCenterById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addCenter(Center center) {
        try {
            centerRepository.save(center);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Center findCenterByName(String nameCenter) {
        return centerRepository.findByName(nameCenter);
    }

    @Override
    public boolean existCenter(String nameCenter) {
        return centerRepository.existsByName(nameCenter);
    }
}
