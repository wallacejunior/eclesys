package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository <EnderecoEntity,Long>{

	EnderecoEntity save(Optional<EnderecoEntity> endereco);
}
