package com.learning.spring_security.service;

import com.learning.spring_security.dto.StudentDTO;
import com.learning.spring_security.entity.StudentEntity;
import com.learning.spring_security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public StudentEntity addStudent(StudentDTO studentDTO){
        return this.studentRepository.save(StudentEntity
                .builder().studentName(studentDTO.studentName()).marks(studentDTO.marks())
                .build()
        );

    }

    public List<StudentEntity> getAllStudents(){
        return this.studentRepository.findAll();
    }

    public StudentEntity findParticularStudent(long id){
        return this.studentRepository.findById(id).orElseThrow(()-> new RuntimeException("STUDENT NOT FOUND"));
    }

    public String deleteStudent(long id){
        if(this.studentRepository.findById(id).isEmpty()) throw new RuntimeException("INVALID ID");
        this.studentRepository.deleteById(id);
        return "DELETE SUCCESSFULLY";
    }

}
