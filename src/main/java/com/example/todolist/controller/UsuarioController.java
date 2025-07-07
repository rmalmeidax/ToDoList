package com.example.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.UsuarioDTO;
import com.example.todolist.entity.UsuarioEntity;
import com.example.todolist.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioEntity> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")

	public ResponseEntity<UsuarioEntity> findById(@PathVariable Long id) {
		UsuarioEntity newId = usuarioService.findById(id);
		return ResponseEntity.ok(newId);

	}

	@PostMapping
	public ResponseEntity<UsuarioEntity> save(@RequestBody UsuarioDTO dto) {

		UsuarioEntity usuario = new UsuarioEntity();

		usuario.setNome(dto.getNome());
		usuario.setId(dto.getId());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());

		UsuarioEntity newusuario = usuarioService.save(usuario);
		newusuario.setSenha(null);
		return ResponseEntity.status(HttpStatus.CREATED).body(newusuario);

	}
}
