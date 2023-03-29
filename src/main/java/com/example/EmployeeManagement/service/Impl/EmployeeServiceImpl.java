package com.example.EmployeeManagement.service.Impl;

import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findByKeyword(String keyword) {
        return employeeRepository.findByKeyword(keyword);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        Employee employee = (Employee) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }
    @Override
    public ResponseEntity<Employee> updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = (Employee) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setPassword(employeeDetails.getPassword());
        employee.setAddress1(employeeDetails.getAddress1());
        employee.setAddress2(employeeDetails.getAddress2());
        employee.setProvince(employeeDetails.getProvince());
        employee.setDistrict(employeeDetails.getDistrict());
        employee.setWard(employeeDetails.getWard());

        Employee updatedEmployee = (Employee) employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id){
        Employee employee = (Employee) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
