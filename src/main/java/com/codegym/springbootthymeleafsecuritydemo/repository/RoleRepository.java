package com.codegym.springbootthymeleafsecuritydemo.repository;

import com.codegym.springbootthymeleafsecuritydemo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
