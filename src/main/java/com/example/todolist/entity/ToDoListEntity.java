package com.example.todolist.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.todolist.enums.CategoriaEnums;
import com.example.todolist.enums.PrioridadeEnums;
import com.example.todolist.enums.StatusEnums;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_todolist")

public class ToDoListEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tarefas;
	
	@Column(columnDefinition = "TEXT")
	private String tarefa;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	private CategoriaEnums categoria;

	@Enumerated(EnumType.STRING)
	private PrioridadeEnums prioridade;

	@Enumerated(EnumType.STRING)
	private StatusEnums status;

}
