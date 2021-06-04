package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PessoaEntity;
import com.example.entity.PessoaEntity;
import com.example.response.Response;
import com.example.service.PessoaService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@RestController
@RequestMapping(value="/membro")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	
	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<PessoaEntity>> create(HttpServletRequest request, @RequestBody PessoaEntity pessoa,
			BindingResult result) {
		Response<PessoaEntity> response = new Response<PessoaEntity>();
		try {
			validateCreatepessoa(pessoa, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			PessoaEntity pessoaPersisted = (PessoaEntity) pessoaService.save(pessoa);
			response.setData(pessoaPersisted);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	private void validateCreatepessoa(PessoaEntity pessoa, BindingResult result) {
		if (pessoa.getEmail() == null) {
			result.addError(new ObjectError("pessoa", "Email no information"));
			return;
		}
	}
	
	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<PessoaEntity>> findById(@PathVariable("id") String id){
		Response<PessoaEntity> response = new Response<PessoaEntity>();
		Optional<PessoaEntity> pessoaOptional = pessoaService.findById(id);
		PessoaEntity pessoa = pessoaOptional.get();
		if (pessoa == null) {
			response.getErrors().add("Register not found id:" + id);
			return  ResponseEntity.badRequest().body(response);
		}
		response.setData(pessoa);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<PessoaEntity>> Update (HttpServletRequest request, @RequestBody PessoaEntity pessoa, BindingResult result){
		
		Response<PessoaEntity> response = new Response<PessoaEntity>();
		
		try{
			validateUpdate(pessoa, result);
			if(result.hasErrors()){
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			PessoaEntity userPersisted = (PessoaEntity) pessoaService.save(pessoa);
			response.setData(userPersisted);
		}catch(Exception e){
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
		return null;
	}
	
	
	private void validateUpdate(PessoaEntity pessoa, BindingResult result) {
		if (pessoa.getId() == null) {
			result.addError(new ObjectError("pessoa", "Id no information"));
			return;
		}
		if (pessoa.getEmail() == null) {
			result.addError(new ObjectError("pessoa", "Email no information"));
			return;
		}
	}
	
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
		Response<String> response = new Response<String>();
		Optional<PessoaEntity> pessoaOptional = pessoaService.findById(id);
		PessoaEntity pessoa = pessoaOptional.get();
		if (pessoa == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		pessoaService.Delete(id);
		return ResponseEntity.ok(new Response<String>());
	}
	
	
	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
    public  ResponseEntity<Response<Page<PessoaEntity>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<PessoaEntity>> response = new Response<Page<PessoaEntity>>();
		Page<PessoaEntity> pessoa = pessoaService.findAll(page, count);
		response.setData(pessoa);
		return ResponseEntity.ok(response);
    }
	
	@GetMapping(value = "{page}/{count}/{number}/{title}/{status}/{priority}/{assigned}")
	@PreAuthorize("hasAnyRole('CUSTOMER','TECHNICIAN')")
    public  ResponseEntity<Response<Page<PessoaEntity>>> findByParams(HttpServletRequest request, 
    		 							@PathVariable int page, 
    		 							@PathVariable int count,
    		 							@PathVariable String nome,
    		 							@PathVariable String nascimento,
    		 							@PathVariable String fone, 
    		 							@PathVariable String email, 
    		 							@PathVariable String Sexo, 
    		 							@PathVariable String cpf, 
    		 							@PathVariable String estadoCivil, 
    		 							@PathVariable String Situacao, 
    		 							@PathVariable String endereco) {
		
		nome = nome.equals("uninformed") ? "" : nome;
		nascimento = nascimento.equals("uninformed") ? "" : nascimento;
		fone = fone.equals("uninformed") ? "" : fone;
		email = email.equals("uninformed") ? "" : email;
		Sexo = Sexo.equals("uninformed") ? "" : Sexo;
		cpf = cpf.equals("uninformed") ? "" : cpf;
		estadoCivil = estadoCivil.equals("uninformed") ? "" : estadoCivil;
		Situacao = Situacao.equals("uninformed") ? "" : Situacao;
		endereco = endereco.equals("uninformed") ? "" : endereco;
		
		
		Response<Page<PessoaEntity>> response = new Response<Page<PessoaEntity>>();
		Page<PessoaEntity> pessoaEntity = null;
		pessoaEntity = pessoaService.findByParameters(page, 
													count, 
													nome,
													nascimento,
													fone,
													email,
													Sexo,
													cpf,
													estadoCivil,
													Situacao,
													endereco);
		
		response.setData(pessoaEntity);
		return ResponseEntity.ok(response);
    }
	
}
