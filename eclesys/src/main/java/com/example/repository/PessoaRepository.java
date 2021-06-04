package com.example.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository <PessoaEntity,Long>{

	Page<PessoaEntity> findByNomeIgnoreCaseContainingAndNascimentoIgnoreCaseContainingAndFoneAndEmailIgnoreCaseContainingAndSexoAndCpfAndEstadoCivilIgnoreCaseContainingAndSituacaoIgnoreCaseContainingOrderByNomeDesc
	(String nome,
			String nascimento, 
			String fone,
			String email,
			String sexo, 
			String cpf,
			String estadoCivil, 
			String Situacao,
			//String endereco,  
			Pageable pages);
}
