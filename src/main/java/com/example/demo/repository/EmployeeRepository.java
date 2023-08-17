package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
        employees.add(new Employee("1", "John"));
        employees.add(new Employee("2", "Sams"));
    }

    public Employee findEmployeeById(String id) {
        return employees.stream().filter(emp -> emp.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    public List<Employee> findAllEmployees() {
        return employees;
    }

}
