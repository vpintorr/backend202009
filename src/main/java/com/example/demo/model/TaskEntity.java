package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TaskEntity {

    @Id
    private int id;

    private String description;
    private boolean completed;
    private TaskPriority priority;
    
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubtaskEntity> subTasks;

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

	public List<SubtaskEntity> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<SubtaskEntity> subTasks) {
		this.subTasks = subTasks;
		
		subTasks.forEach((s)->s.setTask(this));	
	}
	

    
}
