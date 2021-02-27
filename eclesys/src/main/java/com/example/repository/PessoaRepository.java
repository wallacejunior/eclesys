package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository <PessoaEntity,Long>{

	List<PessoaEntity> findByNome(String nome);
	PessoaEntity save(Optional<PessoaEntity> pessoa);
}
