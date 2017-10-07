/**
*
*
* Author : Shaik Fareed
* 
* 
* Description : This class converts model to entity and viceversa
*
*
**/ 
package com.todo.assembler;

import com.todo.entity.TodoEntity;
import com.todo.model.TodoModel;

public class TodoModelEntitAssembler {

	/**
	 * @param todoEntity
	 * @return
	 */
	public static TodoModel populateModelFromEntity(TodoEntity todoEntity) {
		
		TodoModel todoModel = new TodoModel();
		
		if(todoEntity!=null){
			todoModel.setId(todoEntity.getId());
			todoModel.setTitle(todoEntity.getTitle());
			todoModel.setTodoDate(todoEntity.getTodoDate());
			todoModel.setComplete(todoEntity.isComplete());
		}
		
		return todoModel;		
	}
	
	/**
	 * @param todoModel
	 * @return
	 */
	public static TodoEntity populateEntityFromModel(TodoModel todoModel) {
		
		TodoEntity todoEntity = new TodoEntity();
		
		if(todoModel!=null){
			todoEntity.setId(todoModel.getId());
			todoEntity.setTitle(todoModel.getTitle());
			todoEntity.setTodoDate(todoModel.getTodoDate());
			todoEntity.setComplete(todoEntity.isComplete());
		}
		
		return todoEntity;		
	}
	
}
