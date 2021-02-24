package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EnderecoEntity;
import com.example.repository.EnderecoRepository;

@RestController
@RequestMapping(value="/eclesys/Endereco")
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping
	public EnderecoEntity  save(@Validated @RequestBody EnderecoEntity endereco) {
		return enderecoRepository.save(endereco);
	}
}
