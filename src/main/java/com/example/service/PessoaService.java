package com.example.service;

import java.io.Serializable;
import java.util.List;

import com.example.entity.PessoaEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;


public interface PessoaService extends Serializable{

	public List <PessoaEntity> findByNome(String nome) throws InvalidFieldException;
	public PessoaEntity save(PessoaEntity pessoa) throws InvalidFieldException;
}
