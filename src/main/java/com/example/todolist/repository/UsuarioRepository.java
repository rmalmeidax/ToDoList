package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entity.UsuarioEntity;

public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, Long>{

}
