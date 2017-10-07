/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.todo.service;

import java.util.List;

import com.todo.exception.TodoCreationException;
import com.todo.exception.TodoDeletionException;
import com.todo.exception.TodoLoadException;
import com.todo.model.TodoModel;

public interface TodoService {

	List<TodoModel> findAllTodoItems() throws TodoLoadException;

	TodoModel findTodoItemById(String todoId);

	TodoModel saveTodo(TodoModel todoModel) throws TodoCreationException;

	void deleteTodo(String todoId) throws TodoDeletionException;

	TodoModel updateTodo(TodoModel todoModel) throws TodoCreationException;

	
}
