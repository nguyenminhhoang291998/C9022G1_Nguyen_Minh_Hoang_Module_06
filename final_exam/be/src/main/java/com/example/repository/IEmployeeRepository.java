package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select * from employee where center_id is null",nativeQuery = true)
    List<Employee> getEmployeeAddNewCenter();

    @Modifying
    @Transactional
    @Query(value = "update `employee` set center_id = :centerId where id = :adminId",nativeQuery = true)
    void setCenterId(@Param("centerId") Long centerId,@Param("adminId") Long employeeId);
}
