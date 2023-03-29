package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query( value = "SELECT u FROM Employee u WHERE(:keyword is null or lower(u.firstName) LIKE %:keyword%)")
    List<Employee> findByKeyword(@Param("keyword") String keyword);


}
