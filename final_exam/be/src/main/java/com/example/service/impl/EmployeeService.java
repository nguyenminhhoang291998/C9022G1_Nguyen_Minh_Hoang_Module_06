package com.example.service.impl;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmployeeAddNewCenter() {
        return employeeRepository.getEmployeeAddNewCenter();
    }

    @Override
    public boolean setCenterId(Long centerId,Long adminId) {
        try {
            employeeRepository.setCenterId(centerId, adminId);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
