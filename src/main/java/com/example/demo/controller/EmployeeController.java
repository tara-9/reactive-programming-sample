package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        Mono<Employee> response = employeeRepository.findEmployeeById(id);
        System.out.println("Controller Is Out");
        return response;

    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmployees() {
        return Flux.from(src -> employeeRepository.findAllEmployees());
    }

    @GetMapping("/hello")
    public Mono<String> greetAllEmployees() {
        return Mono.just("Hello");
    }
}
