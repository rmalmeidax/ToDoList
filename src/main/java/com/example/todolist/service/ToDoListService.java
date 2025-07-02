package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.entity.ToDoListEntity;
import com.example.todolist.enums.StatusEnums;
import com.example.todolist.repository.ToDoListRepository;

@Service
public class ToDoListService {

	@Autowired
	private ToDoListRepository toDoListRepository;

	public List<ToDoListEntity> findAll() {
		return toDoListRepository.findAll();
	}

	public ToDoListEntity findById(Long id) {
		return toDoListRepository.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + " não encontrado"));

	}

	public List<ToDoListEntity> findByAllStatus(StatusEnums status) {
		return toDoListRepository.findByStatus(status);

	}

	public ToDoListEntity save(ToDoListEntity toDoList) {
		return toDoListRepository.save(toDoList);

	}

	public void deleteById(Long id) {
		toDoListRepository.deleteById(id);
	}

	public List<ToDoListEntity> findByStatus(StatusEnums status) {
		return toDoListRepository.findByStatus(status);
	}
}
