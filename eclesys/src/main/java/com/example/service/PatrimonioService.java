package com.example.service;

import java.io.Serializable;
import java.util.List;

import com.example.entity.PatrimonioEntity;
import com.example.entity.PessoaEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

public interface PatrimonioService extends Serializable{

	public List <PatrimonioEntity> findByDescricao(String descricao) throws InvalidFieldException;
	public List <PatrimonioEntity> findByLocalizacao(String localizacao) throws InvalidFieldException;
	public PatrimonioEntity save(PatrimonioEntity patrimonio) throws InvalidFieldException;
}
