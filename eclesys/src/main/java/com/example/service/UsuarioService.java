package com.example.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.entity.UsuarioEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Component
public interface UsuarioService extends Serializable{

	public Optional <UsuarioEntity> findById(String id);
	public UsuarioEntity findByEmail(String email);
	UsuarioEntity save(UsuarioEntity usuario) ;
	public void Delete(String Id) ;
	Page<UsuarioEntity> findAll(int page, int count);
}
