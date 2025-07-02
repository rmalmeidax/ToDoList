package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entity.ToDoListEntity;
import com.example.todolist.enums.StatusEnums;

public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Long> {

	List<ToDoListEntity> findByStatus(StatusEnums status);

}
