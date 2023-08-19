package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
        employees.add(new Employee("1", "John"));
        employees.add(new Employee("2", "Sams"));
    }

    public Mono<Employee> findEmployeeById(String id) {
        System.out.println(Thread.currentThread().getName());
        CompletableFuture<Employee> employeeCompletableFuture = CompletableFuture.supplyAsync(() -> getEmployeeFromDb(id));
        Mono<Employee> employeeMono = Mono.fromFuture(employeeCompletableFuture);
        System.out.println("Service Is Out");
        return employeeMono;
    }

    public List<Employee> findAllEmployees() {
        return employees;
    }

    public Employee getEmployeeFromDb(String id) {

        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return employees.stream().filter(emp -> emp.getId().equalsIgnoreCase(id)).findFirst().get();
    }

}
