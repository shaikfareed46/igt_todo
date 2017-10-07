/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.todo.exception;

/*
 *   
 *  
 *  
 * 
*/
public class TodoCreationException extends Exception {

	/**
	 * This exception is thrown when there is problem saving customer
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TodoCreationException(){
		super("Order could not be saved:");
	}

	/**
	 * @param msg
	 */
	public TodoCreationException(String msg){
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param t
	 */
	public TodoCreationException(String msg,Throwable t){
		super(msg,t);
	}
}
