package com.microservice.department.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Employee {
    @Id
    private String id;
    private String name;
    private int age;
    private String position;
    private String organizationId;
    private String departmentId;
}
