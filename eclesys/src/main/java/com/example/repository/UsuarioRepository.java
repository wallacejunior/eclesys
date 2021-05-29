package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity,Long> {

	List<UsuarioEntity> findByNome(String nome) ;
	UsuarioEntity save(Optional<UsuarioEntity> usuario) ;
	UsuarioEntity findByEmail(String email);
}
