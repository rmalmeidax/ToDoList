package com.example.todolist.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.todolist.entity.UsuarioEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioDetails implements UserDetails{ 

	private static final long serialVersionUID = 1L;
    private final UsuarioEntity usuarioEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Sem roles por enquanto
	    }

    @Override
    public String getPassword() {
        return usuarioEntity.getSenha();
	    }

    @Override
    public String getUsername() {
	        return usuarioEntity.getEmail();
	    }

    @Override
	public boolean isAccountNonExpired() {
	    return true;
	    }

	@Override
	public boolean isAccountNonLocked() {
	    return true;
	    }

	@Override
	public boolean isCredentialsNonExpired() {
	    return true;
	    }

	 @Override
	 public boolean isEnabled() {
	    return true;
	    }

	 public UsuarioEntity getUsuarioEntity() {
	    return usuarioEntity;
	    }
	}

