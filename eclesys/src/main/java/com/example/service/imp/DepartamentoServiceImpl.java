package com.example.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.DepartamentoEntity;
import com.example.repository.DepartamentoRepository;
import com.example.service.DepartamentoService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Component
public class DepartamentoServiceImpl implements DepartamentoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2990633592816726139L;
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	@Override
	public DepartamentoEntity save(DepartamentoEntity departamento) throws InvalidFieldException {
		return departamentoRepository.save(departamento);
	}

}
