package com.example.demo.Reposetory;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface userReposetory extends CrudRepository<User, Integer> {

}
