/**
*
*
* Author : Shaik Fareed
* 
* 
* Description : Todo controller
*
*
**/ 
package com.todo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.exception.TodoCreationException;
import com.todo.exception.TodoDeletionException;
import com.todo.exception.TodoLoadException;
import com.todo.model.TodoModel;
import com.todo.service.TodoService;

@RestController
public class WebController {

	Logger logger = LoggerFactory.getLogger(WebController.class);
	
	
	
	@Autowired
	private TodoService todoService;
	
	
	/**
	 * @return
	 * @throws TodoLoadException
	 */
	@RequestMapping(value="/todos",method=RequestMethod.GET)
	public List<TodoModel> todoList() throws TodoLoadException{
		
		logger.info("Fethcing the List of todos......");
		
		List<TodoModel> list =  todoService.findAllTodoItems();
		
		return list;
	}
	
	/**
	 * @param todoId
	 * @return
	 * @throws TodoLoadException
	 */
	@RequestMapping(value="/todos/{todoId}",method=RequestMethod.GET)
	public TodoModel getTodoById(@PathVariable("todoId")String todoId) throws TodoLoadException{
		
		logger.info("Fethcing todo by id......");
		
		TodoModel todoModel =   todoService.findTodoItemById(todoId);
		
		return todoModel;
	}
	
	/**
	 * @param todoId
	 * @return
	 * @throws TodoLoadException
	 */
	@RequestMapping(value="/todos",method=RequestMethod.POST)
	public TodoModel saveTodo(@RequestBody TodoModel todoModel) throws TodoCreationException{
		
		logger.info("Saving todo......");
		
		return todoService.saveTodo(todoModel);
		
	}
	
	/**
	 * @param todoModel
	 * @return
	 * @throws TodoCreationException
	 */
	@RequestMapping(value="/todos",method=RequestMethod.PUT)
	public TodoModel updateTodo(@RequestBody TodoModel todoModel) throws TodoCreationException{
		
		logger.info("Update todo......");
		
		return todoService.updateTodo(todoModel);

	}
	
	
	/**
	 * @param todoModel
	 * @throws TodoDeletionException
	 */
	@RequestMapping(value="/todos/{todoId}",method=RequestMethod.DELETE)
	public void deleteTodo(@PathVariable("todoId")String todoId) throws TodoDeletionException{
		
		logger.info("Delete todo......");
		
		todoService.deleteTodo(todoId);
		
	}
	
	/**
	 * @param e
	 * @param model
	 * @return
	 */
	@ExceptionHandler(TodoCreationException.class)
	public String handleException(TodoCreationException e,Map<String,Object> model){
		logger.error(e.getMessage(), e);
		model.put("msg", e.getMessage());
		return "error";
	}
	
	/**
	 * @param e
	 * @param model
	 * @return
	 */
	@ExceptionHandler(TodoLoadException.class)
	public String handleException(TodoLoadException e,Map<String,Object> model){
		logger.error(e.getMessage(), e);
		model.put("msg", e.getMessage());
		return "error";
	}
	
	/**
	 * @param e
	 * @param model
	 * @return
	 */
	@ExceptionHandler(TodoDeletionException.class)
	public String handleException(TodoDeletionException e,Map<String,Object> model){
		logger.error(e.getMessage(), e);
		model.put("msg", e.getMessage());
		return "error";
	}
}
