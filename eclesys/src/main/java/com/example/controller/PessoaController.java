package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PessoaEntity;
import com.example.service.PessoaService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@RestController
@RequestMapping(value="/membro")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public PessoaEntity save(@Validated @RequestBody PessoaEntity pessoa) throws InvalidFieldException {
		return pessoaService.save(pessoa);
	}
	
	@GetMapping("")
	public List<PessoaEntity> findAll() throws InvalidFieldException {
		return pessoaService.findAll();
	}
	
	@GetMapping("/nome/{nome}")
	public List<PessoaEntity> findByNome(String nome) throws InvalidFieldException{
		return pessoaService.findByNome(nome);
	}
	
	@DeleteMapping (value="{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public boolean Delete(Long id) throws InvalidFieldException{
		return pessoaService.Delete(id);
	}
	
}
