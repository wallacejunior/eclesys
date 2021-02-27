package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PessoaEntity;
import com.example.service.PessoaService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@RestController
@RequestMapping(value="eclesys/membro")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public PessoaEntity save(@Validated @RequestBody PessoaEntity pessoa) throws InvalidFieldException {
		return pessoaService.save(pessoa);
	}
	
	
}
