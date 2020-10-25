package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.TaskEntity;
import com.example.demo.model.TaskPriority;

public interface TaskService {
	
	public Page<TaskEntity> getAllTasks(final Optional<String> description,final  Optional<TaskPriority> priority, final Optional<Boolean> completed, Pageable pageable);
	public Optional<TaskEntity> getTaskById(int id);
	public TaskEntity saveTask(TaskEntity task);
	public void deleteTaskById(int id);

}
