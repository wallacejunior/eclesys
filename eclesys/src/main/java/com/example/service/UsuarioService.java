package com.example.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.entity.UsuarioEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

public interface UsuarioService extends Serializable{

	public Optional <UsuarioEntity> findById(String id);
	public UsuarioEntity findByEmail(String email);
	public UsuarioEntity createOrUpdate(UsuarioEntity pessoa);
	public void Delete(String Id) ;
	Page<UsuarioEntity> findAll(int page, int count);
}
