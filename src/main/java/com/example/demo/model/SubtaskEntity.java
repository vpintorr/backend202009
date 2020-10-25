package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SubtaskEntity {

	@Id
    private int id;

    private String description;
    private boolean completed;
    private TaskPriority priority;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TaskEntity task;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public TaskEntity getTask() {
		return task;
	}

	public void setTask(TaskEntity task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "SubtaskEntity [id=" + id + ", description=" + description + ", completed=" + completed + ", priority="
				+ priority + ", task=" + task + "]";
	}
	
	
	
    
    
}
