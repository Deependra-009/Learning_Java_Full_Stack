package com.learning.spring_security.controllers;

import com.learning.spring_security.dto.StudentDTO;
import com.learning.spring_security.entity.StudentEntity;
import com.learning.spring_security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public String test(){
        return "STUDENT CONTROLLER RUN SUCCESSFULLY";
    }

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> addStudent(@RequestBody  StudentDTO studentDTO){
        return new ResponseEntity<>(this.studentService.addStudent(studentDTO), HttpStatus.OK);
    }

    @GetMapping("/get-all-student")
    public ResponseEntity<List<StudentEntity>> findAllStudent(){
        return new ResponseEntity<>(this.studentService.getAllStudents(),HttpStatus.OK );
    }

    @GetMapping("/get-particular-student/{id}")
    public ResponseEntity<StudentEntity> findParticularStudent(@PathVariable("id") long id){
        return new ResponseEntity<>(this.studentService.findParticularStudent(id),HttpStatus.OK );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        return new ResponseEntity<>(this.studentService.deleteStudent(id),HttpStatus.OK);
    }




}
