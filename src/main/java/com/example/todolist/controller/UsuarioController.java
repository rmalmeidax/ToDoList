package com.example.todolist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.entity.UsuarioEntity;
import com.example.todolist.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping("/auth/login")
	public ResponseEntity<UsuarioEntity> save(@RequestBody UsuarioEntity usuarioEntity) {
		UsuarioEntity usuario = usuarioService.save(usuarioEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

}
