package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UsuarioEntity;
import com.example.service.UsuarioService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@RestController
@RequestMapping(value="/eclesys/log")
public class UsuarioController {

	@Autowired(required=true)
	private UsuarioService usuarioService;
	
	@PostMapping
	public UsuarioEntity save(@Validated @RequestBody UsuarioEntity usuario) throws InvalidFieldException {
		
		return usuarioService.save(usuario);
	}
	
	@GetMapping("/nome/{nome}")
	public List<UsuarioEntity> findByNome(String usuario) throws InvalidFieldException{
		return usuarioService.findByNome(usuario);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidFields(InvalidFieldException ex){
		return ex.getMessage();
	}
	
	
}
