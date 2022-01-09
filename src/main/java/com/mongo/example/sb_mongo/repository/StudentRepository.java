package com.mongo.example.sb_mongo.repository;

import com.mongo.example.sb_mongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface StudentRepository extends MongoRepository<Student,Integer> {
}
