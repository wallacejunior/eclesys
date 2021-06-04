package com.example.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PatrimonioEntity;
import com.example.repository.PatrimonioRepository;
import com.example.response.Response;
import com.example.service.PatrimonioService;

@RestController
@RequestMapping(value="/Patrimonio")
public class PatrimonioController {

	@Autowired
	PatrimonioRepository patrimonioRepository;
	
	@Autowired
	private PatrimonioService patrimonioService;
	
	@PostMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<PatrimonioEntity>> create(HttpServletRequest request, @RequestBody PatrimonioEntity patrimonio,
			BindingResult result) {
		Response<PatrimonioEntity> response = new Response<PatrimonioEntity>();
		try {
			validateCreatePatrimonio(patrimonio, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			PatrimonioEntity patrimonioPersisted = (PatrimonioEntity) patrimonioRepository.save(patrimonio);
			response.setData(patrimonioPersisted);
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("E-mail already registered !");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	private void validateCreatePatrimonio(PatrimonioEntity patrimonio, BindingResult result) {
		if (patrimonio.getDescricao() == null) {
			result.addError(new ObjectError("Patrimonio", "Descrição não informada!"));
			return;
		}
		if (patrimonio.getDepartamento().getId() == null) {
			
		}
	}
	
	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<PatrimonioEntity>> findById(@PathVariable("id") String id){
		Response<PatrimonioEntity> response = new Response<PatrimonioEntity>();
		Optional<PatrimonioEntity> patrimonioOptional = patrimonioService.findById(id);
		PatrimonioEntity patrimonio = patrimonioOptional.get();
		if (patrimonio == null) {
			response.getErrors().add("Register not found id:" + id);
			return  ResponseEntity.badRequest().body(response);
		}
		response.setData(patrimonio);
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<PatrimonioEntity>> Update (HttpServletRequest request, @RequestBody PatrimonioEntity patrimonio, BindingResult result){
		
		Response<PatrimonioEntity> response = new Response<PatrimonioEntity>();
		
		try{
			validateUpdate(patrimonio, result);
			if(result.hasErrors()){
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			PatrimonioEntity patrimonioPersisted = (PatrimonioEntity) patrimonioService.save(patrimonio);
			response.setData(patrimonioPersisted);
		}catch(Exception e){
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
		return null;
	}
	
	
	private void validateUpdate(PatrimonioEntity patrimonio, BindingResult result) {
		if (patrimonio.getId() == null) {
			result.addError(new ObjectError("patrimonio", "Id no informada"));
			return;
		}
		if (patrimonio.getDescricao() == null) {
			result.addError(new ObjectError("patrimonio", "descrição não informada"));
			return;
		}
	}
	
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
		Response<String> response = new Response<String>();
		Optional<PatrimonioEntity> patrimonioOptional = patrimonioService.findById(id);
		PatrimonioEntity pessoa = patrimonioOptional.get();
		if (pessoa == null) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
		patrimonioService.Delete(id);
		return ResponseEntity.ok(new Response<String>());
	}
	
	
	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
    public  ResponseEntity<Response<Page<PatrimonioEntity>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<PatrimonioEntity>> response = new Response<Page<PatrimonioEntity>>();
		Page<PatrimonioEntity> patrimonio = patrimonioService.findAll(page, count);
		response.setData(patrimonio);
		return ResponseEntity.ok(response);
    }
	
	@GetMapping(value = "{page}/{count}/{number}/{title}/{status}/{priority}/{assigned}")
	@PreAuthorize("hasAnyRole('CUSTOMER','TECHNICIAN')")
    public  ResponseEntity<Response<Page<PatrimonioEntity>>> findByParams(HttpServletRequest request, 
    		 							@PathVariable int page, 
    		 							@PathVariable int count,
    		 							@PathVariable String descricao,
    		 							@PathVariable String localizacao,
    		 							@PathVariable String departamentoId) {
		
		descricao = descricao.equals("uninformed") ? "" : descricao;
		localizacao = localizacao.equals("uninformed") ? "" : localizacao;
		departamentoId = departamentoId.equals("uninformed") ? "" : departamentoId;		
		
		Response<Page<PatrimonioEntity>> response = new Response<Page<PatrimonioEntity>>();
		Page<PatrimonioEntity> patrimonioEntity = null;
		patrimonioEntity = patrimonioService.findByParameters(page, 
													count, 
													descricao,
													localizacao,
													departamentoId);
		
		response.setData(patrimonioEntity);
		return ResponseEntity.ok(response);
    }
}
