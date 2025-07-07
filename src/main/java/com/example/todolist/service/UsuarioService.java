package com.example.todolist.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todolist.entity.UsuarioEntity;
import com.example.todolist.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public List<UsuarioEntity> findAll() {
		return usuarioRepository.findAll();
	}

	public UsuarioEntity save(UsuarioEntity usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	public UsuarioEntity findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + "Não encontrado"));

	}

}
