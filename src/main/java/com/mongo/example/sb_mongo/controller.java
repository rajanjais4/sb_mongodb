package com.mongo.example.sb_mongo;


import com.mongo.example.sb_mongo.model.Student;
import com.mongo.example.sb_mongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class controller {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
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

    @GetMapping("/getAge")
    @RequestMapping(value = "/getAge/{age}")
    public ResponseEntity<?> getStudentWithAgeGreaterThenInput(@PathVariable Integer age){
        Query ageQuery= Query
                .query(Criteria.where("age").gt(age));
        System.out.println(age);
        List<Student> studentList=this.mongoTemplate.find(ageQuery,Student.class);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/getName")
    @RequestMapping(value = "/getName/{name}")
    public ResponseEntity<?> getStudentWithName(@PathVariable String name){
        Query nameQuery= Query
                .query(Criteria.where("Name").is(name));
        System.out.println(name);
        List<Student> studentList=this.mongoTemplate.find(nameQuery,Student.class);
        return ResponseEntity.ok(studentList);
    }

}
