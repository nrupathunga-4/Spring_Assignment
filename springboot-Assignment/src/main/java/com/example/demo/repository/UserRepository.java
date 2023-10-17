package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserPage;

public interface UserRepository extends JpaRepository<UserPage, Long>{

}
