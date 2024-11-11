package com.example.demo.Reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface userReposetory extends JpaRepository<User, Long> {

}
