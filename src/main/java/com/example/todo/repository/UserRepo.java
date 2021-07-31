package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
