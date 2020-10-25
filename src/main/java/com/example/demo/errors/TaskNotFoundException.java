package com.example.demo.errors;

public class TaskNotFoundException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8359167170408725765L;

	public TaskNotFoundException(int id) {
        super("Task with id "+id+" not found");
    }
}