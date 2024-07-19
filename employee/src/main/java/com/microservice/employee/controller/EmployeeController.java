package com.microservice.employee.controller;

import com.microservice.employee.model.Employee;
import com.microservice.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable String departmentId) {
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }
}
