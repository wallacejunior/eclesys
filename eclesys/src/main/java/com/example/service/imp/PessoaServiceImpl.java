package com.example.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entity.PessoaEntity;
import com.example.repository.PessoaRepository;
import com.example.service.PessoaService;

@Component
public class PessoaServiceImpl implements PessoaService{

	
	private static final long serialVersionUID = 7741442133075317433L;
	
	@Autowired
	private PessoaRepository pessoaRepository;


	@Override
	public Page<PessoaEntity> findByParameters(int page, 
												int count,
												String nome,
												String nascimento,
												String fone, 
												String email, 
												String Sexo, 
												String cpf, 
												String estadoCivil, 
												String Situacao, 
												String endereco) {
		Pageable pages = PageRequest.of(page, count);
		return this.pessoaRepository.
				findByNomeIgnoreCaseContainingAndNascimentoIgnoreCaseContainingAndFoneAndEmailIgnoreCaseContainingAndSexoAndCpfAndEstadoCivilIgnoreCaseContainingAndSituacaoIgnoreCaseContainingOrderByNomeDesc(
				 nome, 
				 nascimento, 
				 fone,  
				 email,  
				 Sexo,  
				 cpf,  
				 estadoCivil,  
				 Situacao, 
				 //endereco, 
				 pages);
	}
	
	@Override
	public Optional<PessoaEntity> findById(String id) {
		return pessoaRepository.findById(Long.valueOf(id).longValue());
		
	}
	
	@Override
	public PessoaEntity save(PessoaEntity pessoa)  {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void Delete(String Id) {
		pessoaRepository.deleteById(Long.valueOf(Id).longValue());
	}

	@Override
	public Page<PessoaEntity> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.pessoaRepository.findAll(pages);
	}

}
