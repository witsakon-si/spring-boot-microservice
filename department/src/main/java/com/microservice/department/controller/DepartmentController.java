package com.microservice.department.controller;

import com.microservice.department.model.Department;
import com.microservice.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable String id) {
        return departmentService.findDepartmentById(id);
    }

    @PostMapping
    public Department addNewDepartment(@RequestBody Department department) {
        return departmentService.addNewDepartment(department);
    }

    @PutMapping("/{id}")
    public Department putDepartment(@PathVariable String id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }


}
