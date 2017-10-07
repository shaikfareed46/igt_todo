/**
 * 
 * Copyright of Accurate Background 
 * 
 * Author: Shaik Fareed
 * 
 * Team : Microservices
 */
package com.todo.exception;

public class TodoLoadException extends Exception {


	/**
	 * This exception is thrown when there is problem fetching customer
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TodoLoadException(){
		super("Could not fetch order list:");
	}

	/**
	 * @param msg
	 */
	public TodoLoadException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public TodoLoadException(String msg,Throwable t){
		super(msg,t);
	}

}
