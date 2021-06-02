package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PatrimonioEntity;
import com.example.repository.PatrimonioRepository;

@RestController
@RequestMapping(value="/Patrimonio")
public class PatrimonioController {

	@Autowired
	PatrimonioRepository patrimonioRepository;
	
	@PostMapping
	public PatrimonioEntity save(@Validated @RequestBody PatrimonioEntity patrimonio) {
		return patrimonioRepository.save(patrimonio);
	}
	
	@GetMapping("/descricao/{descricao}")
	public List<PatrimonioEntity> findByDescricao(String descricao){
		return patrimonioRepository.findByDescricao(descricao);
	}
	
	@GetMapping("/localizacao/{localizacao}")
	public List<PatrimonioEntity> findByLocalizacao(String localizacao){
		return patrimonioRepository.findByLocalizacao(localizacao);
	}
}
