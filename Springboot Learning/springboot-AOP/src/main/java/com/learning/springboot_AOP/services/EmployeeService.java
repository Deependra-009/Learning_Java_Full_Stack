package com.learning.springboot_AOP.services;

import com.learning.springboot_AOP.entity.EmployeeEntity;
import com.learning.springboot_AOP.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee(){
        return this.employeeRepository.findAll();
    }

    public String addEmployee(EmployeeEntity employeeEntity) throws Exception {
        if(employeeEntity.getName().isBlank()){
            throw new Exception("Name should not be blank");
        }
        this.employeeRepository.save(employeeEntity);
        return "Add Successfully";

    }
}
