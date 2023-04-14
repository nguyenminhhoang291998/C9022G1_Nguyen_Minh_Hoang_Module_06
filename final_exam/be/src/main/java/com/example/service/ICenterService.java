package com.example.service;

import com.example.dto.ICenterDTO;
import com.example.model.Center;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICenterService {
    Page<ICenterDTO> findAllCenter(String nameCenter,  String nameEmployee, Pageable pageable);

    boolean deleteById(Long id);

    boolean addCenter(Center center);

    Center findCenterByName(String nameCenter);

    boolean existCenter(String nameCenter);


}
