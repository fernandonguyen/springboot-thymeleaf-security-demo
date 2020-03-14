package com.codegym.springbootthymeleafsecuritydemo.repository;

import com.codegym.springbootthymeleafsecuritydemo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
