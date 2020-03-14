package com.codegym.springbootthymeleafsecuritydemo.repository;

import com.codegym.springbootthymeleafsecuritydemo.entities.Student;
import com.codegym.springbootthymeleafsecuritydemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
}
