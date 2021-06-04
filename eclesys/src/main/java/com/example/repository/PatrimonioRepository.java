package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.PatrimonioEntity;

public interface PatrimonioRepository extends JpaRepository <PatrimonioEntity,Long>{
	
	public Page<PatrimonioEntity>  findByDescricaoIgnoreCaseContainingAndLocalizacaoIgnoreCaseContainingOrderByLocalizacao (String descricao,
			String localizacao,
			//String departamentoId,
			Pageable page);
	//Optional<PatrimonioEntity> findById(String id) ;
}
