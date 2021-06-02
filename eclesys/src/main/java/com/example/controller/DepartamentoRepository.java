package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.DepartamentoEntity;

@RestController
@RequestMapping(value="/departamento")
public class DepartamentoRepository {

	@Autowired
	DepartamentoRepository departamentoRepository;
	
	@PostMapping
	public DepartamentoEntity save(@Validated @RequestBody DepartamentoEntity departamento) {
		return departamentoRepository.save(departamento);
	}
	
}
