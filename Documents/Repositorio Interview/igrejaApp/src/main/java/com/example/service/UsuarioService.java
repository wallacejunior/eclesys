package com.example.service;

import java.io.Serializable;
import java.util.List;

import com.example.entity.UsuarioEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

public interface UsuarioService extends Serializable{

	public List <UsuarioEntity> findByNome(String nome) throws InvalidFieldException;
	public UsuarioEntity save(UsuarioEntity pessoa) throws InvalidFieldException;
}
