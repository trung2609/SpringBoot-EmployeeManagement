package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    public List<Employee> findByKeyword(String keyword);

    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public ResponseEntity<Employee> getEmployeeById(Long id) throws Exception;
    public ResponseEntity<Employee> updateEmployee(Long id,Employee employeeDetails) throws Exception;
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) throws Exception;
}
