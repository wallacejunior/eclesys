package com.example.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entity.EnderecoEntity;
import com.example.repository.EnderecoRepository;
import com.example.service.EnderecoService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Component
public class EnderecoServiceImpl implements EnderecoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2725814840735185453L;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public EnderecoEntity save(EnderecoEntity endereco) throws InvalidFieldException {
		return enderecoRepository.save(endereco);
	}

}
