package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity,Long> {

	UsuarioEntity findByEmail(String email);
	Optional<UsuarioEntity> findById(String id) ;
	UsuarioEntity createOrUpdate(UsuarioEntity usuario) ;
	UsuarioEntity deleteById(String id);
	
}
