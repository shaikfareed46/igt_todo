/**
 * 
 * Copyright of Accurate Background 
 * 
 * Author: Shaik Fareed
 * 
 * Team : Microservices
 */
package com.todo.exception;

public class TodoDeletionException extends Exception {
	/**
	 * This exception is thrown when there is problem fetching customer
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TodoDeletionException(){
		super("Could not delete order");
	}

	/**
	 * @param msg
	 */
	public TodoDeletionException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public TodoDeletionException(String msg,Throwable t){
		super(msg,t);
	}

}
