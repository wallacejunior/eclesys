package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity,Long> {

	UsuarioEntity findByEmail(String email);
}
