package com.example.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.entity.PatrimonioEntity;
import com.example.entity.PessoaEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

public interface PatrimonioService extends Serializable{

	public Page<PatrimonioEntity> findByParameters (int page, 
			int count,
			String descricao,
			String localizacao,
			String departamentoId) ;
	public Optional<PatrimonioEntity> findById(String Id);
	public PatrimonioEntity save(PatrimonioEntity patrimonio);
	public void Delete(String id) ;
	public Page<PatrimonioEntity> findAll(int page, int count);
}
