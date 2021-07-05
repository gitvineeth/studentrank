package com.example.studentrank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentrank.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
