/**
*
*
* Author : Shaik Fareed
* 
* 
* Description : Todoservice layer
*
*
**/  
package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.assembler.TodoModelEntitAssembler;
import com.todo.entity.TodoEntity;
import com.todo.entity.TodoSequences;
import com.todo.exception.TodoCreationException;
import com.todo.exception.TodoDeletionException;
import com.todo.exception.TodoLoadException;
import com.todo.model.TodoModel;
import com.todo.repository.TodoRepository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepo;
	
	@Autowired 
	private MongoOperations mongo;
	
	public int getNextSequence(String seqName)
    {
        TodoSequences counter = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            TodoSequences.class);
        return counter.getSeq();
    }

	
	/* (non-Javadoc)
	 * @see com.ab.service.TodoService#findAllTodoItems()
	 */
	@Override
	public List<TodoModel> findAllTodoItems() throws TodoLoadException {
		
		List<TodoEntity> list = todoRepo.findAll();
		
		List<TodoModel> orderModelList = new ArrayList<>();
		
		try{
			if(list!=null){
				list.forEach(product -> {
					orderModelList.add(TodoModelEntitAssembler.populateModelFromEntity(product));
				});
			}
		}catch(Exception e){
			throw new TodoLoadException(e.getMessage(),e);
		}
		
		return orderModelList;
	}

	/* (non-Javadoc)
	 * @see com.ab.service.TodoService#findTodoItemById(java.lang.String)
	 */
	@Override
	public TodoModel findTodoItemById(String todoId) {
		return TodoModelEntitAssembler.populateModelFromEntity(todoRepo.findOne(Integer.parseInt(todoId)));
	}

	/* (non-Javadoc)
	 * @see com.ab.service.TodoService#saveTodo(com.ab.model.TodoModel)
	 */
	@Override
	public TodoModel saveTodo(TodoModel todoModel) throws TodoCreationException {
		TodoEntity todoEntity = TodoModelEntitAssembler.populateEntityFromModel(todoModel);
		
		try{
			todoEntity.setId(getNextSequence("todoSequence"));
			
			todoRepo.save(todoEntity);
			
			return TodoModelEntitAssembler.populateModelFromEntity(todoEntity);
			
		}catch(Exception e){
			throw new TodoCreationException(e.getMessage(),e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ab.service.TodoService#deleteTodo(java.lang.String)
	 */
	@Override
	public void deleteTodo(String todoId) throws TodoDeletionException {
		try{
			todoRepo.delete(Integer.parseInt(todoId));
		}catch(Exception e){
			throw new TodoDeletionException(e.getMessage(),e);
		}
	}


	@Override
	public TodoModel updateTodo(TodoModel todoModel) throws TodoCreationException {
		try{
			
			TodoEntity todoEntity = todoRepo.findOne(todoModel.getId());
			todoEntity.setComplete(todoModel.isComplete());
			todoEntity.setTitle(todoModel.getTitle());
			todoEntity.setTodoDate(todoModel.getTodoDate());
			todoRepo.save(todoEntity);
			return TodoModelEntitAssembler.populateModelFromEntity(todoEntity);
		}catch(Exception e){
			throw new TodoCreationException(e.getMessage(),e);
		}
	}
	
}
