package com.microservice.department.service;

import com.microservice.department.model.Department;
import com.microservice.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(String id) {
        Optional<Department> department = departmentRepository.findById(id);
        department.ifPresent(d -> {
            d.setEmployees(Collections.emptyList()); // TODO: call employee service for get list of employee
        });

        return department.orElse(null);
    }

    public Department findDepartmentByIdRecovery(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department department) {
        departmentRepository.findById(departmentId).ifPresent(d -> department.setId(d.getId()));
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }


}
