package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer>, JpaSpecificationExecutor<TaskEntity> {

}
