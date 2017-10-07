/**
*
*
* Author : Shaik Fareed
* 
*
**/ 
package com.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todo.entity.TodoEntity;

public interface TodoRepository extends MongoRepository<TodoEntity, Integer> {

}
