package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DepartamentoEntity;

public interface DepartamentoRepository extends JpaRepository <DepartamentoEntity,Long>{

}
