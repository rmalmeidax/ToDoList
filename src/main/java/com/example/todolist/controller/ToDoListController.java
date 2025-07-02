package com.example.todolist.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.ToDoListDTO;
import com.example.todolist.entity.ToDoListEntity;
import com.example.todolist.enums.StatusEnums;
import com.example.todolist.service.ToDoListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todolist")
@RequiredArgsConstructor
public class ToDoListController {

	private final ToDoListService toDoListService;

	private final ModelMapper modelMapper;

	@GetMapping
	public List<ToDoListEntity> findAll() {
		return toDoListService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Long id) {

		ToDoListEntity todolist = toDoListService.findById(id);
		return ResponseEntity.ok(todolist);
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<List<ToDoListDTO>> findByStatus(@PathVariable StatusEnums status) {

		List<ToDoListEntity> entidades = toDoListService.findByAllStatus(status);
		List<ToDoListDTO> dtos = entidades.stream().map(entity -> modelMapper.map(entity, ToDoListDTO.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(dtos);

	}

	@PostMapping
	public ResponseEntity<ToDoListDTO> save(@RequestBody ToDoListDTO toDoList) {

		ToDoListEntity entity = modelMapper.map(toDoList, ToDoListEntity.class);
		ToDoListEntity saveEntity = toDoListService.save(entity);
		ToDoListDTO newToDoListdto = modelMapper.map(saveEntity, ToDoListDTO.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(newToDoListdto);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		toDoListService.deleteById(id);
		return ResponseEntity.ok(id).noContent().build();
	}

}
