package com.mongo.example.sb_mongo;


import com.mongo.example.sb_mongo.model.Student;
import com.mongo.example.sb_mongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class controller {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student saved=this.studentRepository.save(student);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStudent(){
        List<Student> studentList=this.studentRepository.findAll();
        System.out.println("inside get student"+studentList.size());
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
}
