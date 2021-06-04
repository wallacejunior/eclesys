package com.example.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.entity.PessoaEntity;
import com.example.entity.UsuarioEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;


public interface PessoaService extends Serializable{

	public Page<PessoaEntity> findByParameters (int page, 
												int count,
												String nome,
												String nascimento,
												String fone, 
												String email, 
												String Sexo, 
												String cpf, 
												String estadoCivil, 
												String Situacao, 
												String endereco) ;
	public Optional<PessoaEntity> findById(String email);
	public PessoaEntity save(PessoaEntity pessoa);
	public void Delete(String Id) ;
	public Page<PessoaEntity> findAll(int page, int count);
}
