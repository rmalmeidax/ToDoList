package com.example.todolist.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.todolist.enums.CategoriaEnums;
import com.example.todolist.enums.PrioridadeEnums;
import com.example.todolist.enums.StatusEnums;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListDTO {
	
	private Long id;

	private String tarefa;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	
	private CategoriaEnums categoria;
	private PrioridadeEnums prioridade;
	private StatusEnums status;

}
