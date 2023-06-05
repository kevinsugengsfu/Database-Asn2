package com.example.demo.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository <Student, Integer> {
  List<Student> findByName(String name);
  List<Student> findByNameAndWeight(String name, int Weight);
  List<Student> findByUid(int uid);
}
