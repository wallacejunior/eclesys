package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.PatrimonioEntity;

public interface PatrimonioRepository extends JpaRepository <PatrimonioEntity,Long>{

	List<PatrimonioEntity> findByDescricao(String descricao);

	List<PatrimonioEntity> findByLocalizacao(String localizacao);

}
