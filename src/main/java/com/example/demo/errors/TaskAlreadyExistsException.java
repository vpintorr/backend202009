package com.example.demo.errors;

public class TaskAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6029128677160207897L;

	public TaskAlreadyExistsException(int id) {
        super("Movie with id "+id+" already exists.");

    }

}
