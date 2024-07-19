package com.microservice.employee.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String departmentId;
}
