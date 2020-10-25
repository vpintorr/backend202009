package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.errors.TaskAlreadyExistsException;
import com.example.demo.errors.TaskNotFoundException;
import com.example.demo.model.TaskEntity;
import com.example.demo.model.TaskPriority;
import com.example.demo.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/task")
	 public Iterable<TaskEntity> getAllTasks(@RequestParam("description") Optional<String> description, @RequestParam("priority") Optional<TaskPriority> priority, @RequestParam("completed") Optional<Boolean> completed, Pageable pageable) {
	    return taskService.getAllTasks(description, priority, completed, pageable);
	  }
	
	@GetMapping("/task/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable int id) {
		TaskEntity found = taskService.getTaskById(id).orElseThrow(() -> new TaskNotFoundException(id));
		return ResponseEntity.ok(found);	
	}
	
	@PostMapping("/task") 
	public ResponseEntity<?>  addNewTask (@RequestBody TaskEntity tasktoAdd) {
		boolean alreadyExists = taskService.getTaskById(tasktoAdd.getId()).isPresent();
		
		if (alreadyExists) {
			throw new TaskAlreadyExistsException(tasktoAdd.getId());
		}
		else {
			TaskEntity saved = taskService.saveTask(tasktoAdd);
			return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		}
	 }
	
	@PutMapping("/task/{id}")
	public ResponseEntity<?> updateEntityById(@RequestBody TaskEntity tasktoUpdate, @PathVariable int id) {
		taskService.getTaskById(id).orElseThrow(() -> new TaskNotFoundException(id));
		TaskEntity updated = taskService.saveTask(tasktoUpdate);
		return ResponseEntity.ok(taskService.saveTask(updated));
	}
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<?> deleteEntityById(@PathVariable int id) {
		taskService.getTaskById(id).orElseThrow(() -> new TaskNotFoundException(id));
		taskService.deleteTaskById(id);
		return ResponseEntity.noContent().build();
	}
}
