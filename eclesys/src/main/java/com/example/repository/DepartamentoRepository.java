package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DepartamentoEntity;

//@EnableJpaRepositories(basePackages = {"com.example.repository"})
public interface DepartamentoRepository extends JpaRepository <DepartamentoEntity,Long>{
	List<DepartamentoEntity> findByNome(String nome) ;
}
