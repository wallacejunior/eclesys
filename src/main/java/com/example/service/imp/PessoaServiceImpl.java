package com.example.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.PessoaEntity;
import com.example.repository.PessoaRepository;
import com.example.service.PessoaService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Service
public class PessoaServiceImpl implements PessoaService{

	
	private static final long serialVersionUID = 7741442133075317433L;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<PessoaEntity> findByNome(String nome) throws InvalidFieldException {
		return pessoaRepository.findByNome(nome);
		
	}

	@Override
	public PessoaEntity save(PessoaEntity pessoa) throws InvalidFieldException {
		return pessoaRepository.save(pessoa);
	}

}
