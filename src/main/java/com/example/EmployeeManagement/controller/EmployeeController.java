package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody @Valid Employee employee) {
        return (Employee) employeeService.createEmployee(employee);
    }

    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws Throwable {
        return (ResponseEntity<Employee>) employeeService.getEmployeeById(id);
    }

    // update employee rest api

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody @Valid Employee employeeDetails) throws Throwable {
        return (ResponseEntity<Employee>) employeeService.updateEmployee(id, employeeDetails);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        return (ResponseEntity<Map<String, Boolean>>) employeeService.deleteEmployee(id);
    }
    @GetMapping("/employees/rearch")
    public List<Employee> searchEmployee(@RequestParam(required = false) String keyword){
        return employeeService.findByKeyword(keyword);
    }
}
