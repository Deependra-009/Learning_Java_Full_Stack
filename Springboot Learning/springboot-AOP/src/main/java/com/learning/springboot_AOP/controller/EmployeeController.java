package com.learning.springboot_AOP.controller;

import com.learning.springboot_AOP.entity.EmployeeEntity;
import com.learning.springboot_AOP.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aop")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<List<EmployeeEntity>> fetchAllEmployee(){
        return new ResponseEntity<>(this.employeeService.getAllEmployee(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employeeEntity) throws Exception{
        return new ResponseEntity<>(this.employeeService.addEmployee(employeeEntity),HttpStatus.ACCEPTED);
    }
}
