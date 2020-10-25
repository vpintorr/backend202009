package com.example.demo.service;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaskEntity;
import com.example.demo.model.TaskPriority;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskServiceImp implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Page<TaskEntity> getAllTasks(final Optional<String> description, final Optional<TaskPriority> priority, final Optional<Boolean> completed, Pageable pageable){
		
		Specification<TaskEntity> specDescription = new Specification<TaskEntity>() {

			@Override
			public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				if(description.isPresent()) {
					return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + description.get() + "%");
				} else {
					return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
				}
			}
			
		};
		
		
		Specification<TaskEntity> specPriority = new Specification<TaskEntity>() {

			@Override
			public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				if(priority.isPresent()) {
					return criteriaBuilder.equal(root.get("priority"), priority.get());
				} else {
					return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
				}
			}
			
		};
		
		Specification<TaskEntity> specCompleted = new Specification<TaskEntity>() {

			@Override
			public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				if(completed.isPresent()) {
					return criteriaBuilder.equal(root.get("completed"), completed.get());
				} else {
					return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
				}
			}
			
		};
		
		Specification<TaskEntity> filterByQuery = specDescription.and(specPriority).and(specCompleted);
		
		return taskRepository.findAll(filterByQuery, pageable);
	}
	
	public Optional<TaskEntity> getTaskById(int id){
		return taskRepository.findById(id);
	}
	
	public TaskEntity saveTask(TaskEntity task) {
		return taskRepository.save(task);
	}
	
	public void deleteTaskById(int id) {
		taskRepository.deleteById(id);
	}
	
	
}
