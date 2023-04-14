package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee findById(Long id);

    List<Employee> getEmployeeAddNewCenter();

    boolean setCenterId(Long centerId,Long adminId);
}
