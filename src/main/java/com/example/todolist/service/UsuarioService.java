package com.example.todolist.service;

import org.springframework.stereotype.Service;

import com.example.todolist.entity.UsuarioEntity;
import com.example.todolist.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	

	public UsuarioEntity save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

}
