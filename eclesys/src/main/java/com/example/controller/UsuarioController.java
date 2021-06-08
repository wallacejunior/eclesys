package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UsuarioEntity;
import com.example.service.UsuarioService;
import com.example.response.Response;
import com.igrejaApp.Exceptions.InvalidFieldException;

@RestController
@RequestMapping(value="/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired(required=true)
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<UsuarioEntity>> create(HttpServletRequest request, @RequestBody UsuarioEntity usuario,
			BindingResult result) {
		Response<UsuarioEntity> response = new Response<UsuarioEntity>();
		try {
			validateCreateUser(usuario, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			UsuarioEntity userPersisted = (UsuarioEntity) usuarioService.save(usuario);
			response.setData(userPersisted);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	private void validateCreateUser(UsuarioEntity usuario, BindingResult result) {
		if (usuario.getEmail() == null) {
			result.addError(new ObjectError("usuario", "Email no information"));
			return;
		}
	}
	
	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<UsuarioEntity>> findById(@PathVariable("id") String id){
		Response<UsuarioEntity> response = new Response<UsuarioEntity>();
		Optional<UsuarioEntity> usuarioOptional = usuarioService.findById(id);
		UsuarioEntity usuario = usuarioOptional.get();
		if (usuario == null) {
			response.getErrors().add("Register not found id:" + id);
			return  ResponseEntity.badRequest().body(response);
		}
		response.setData(usuario);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<UsuarioEntity>> Update (HttpServletRequest request, @RequestBody UsuarioEntity usuario, BindingResult result){
		
		Response<UsuarioEntity> response = new Response<UsuarioEntity>();
		
		try{
			validateUpdate(usuario, result);
			if(result.hasErrors()){
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			UsuarioEntity userPersisted = (UsuarioEntity) usuarioService.save(usuario);
			response.setData(userPersisted);
		}catch(Exception e){
			
		}
		
		return null;
	}
	
	
	private void validateUpdate(UsuarioEntity user, BindingResult result) {
		if (user.getId() == null) {
			result.addError(new ObjectError("User", "Id no information"));
			return;
		}
		if (user.getEmail() == null) {
			result.addError(new ObjectError("User", "Email no information"));
			return;
		}
	}
	
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
		Response<String> response = new Response<String>();
		Optional<UsuarioEntity> userOptional = usuarioService.findById(id);
		UsuarioEntity user = userOptional.get();
		if (user == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		usuarioService.Delete(id);
		return ResponseEntity.ok(new Response<String>());
	}
	
	
	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
    public  ResponseEntity<Response<Page<UsuarioEntity>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<UsuarioEntity>> response = new Response<Page<UsuarioEntity>>();
		Page<UsuarioEntity> users = usuarioService.findAll(page, count);
		response.setData(users);
		return ResponseEntity.ok(response);
    }
	
	
}
