package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
