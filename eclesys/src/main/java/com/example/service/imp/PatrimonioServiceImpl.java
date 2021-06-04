package com.example.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entity.PatrimonioEntity;
import com.example.entity.PessoaEntity;
import com.example.repository.PatrimonioRepository;
import com.example.service.PatrimonioService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Component
public class PatrimonioServiceImpl implements PatrimonioService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2307605913625283530L;
	
	@Autowired
	PatrimonioRepository patrimonioRepository;

	@Override
	public  Page<PatrimonioEntity> findByParameters (int page, 
			int count,
			String descricao,
			String localizacao,
			String departamentoId) {
		Pageable pages = PageRequest.of(page, count);
		return patrimonioRepository.findByDescricaoIgnoreCaseContainingAndLocalizacaoIgnoreCaseContainingOrderByLocalizacao(descricao, localizacao, pages);
		
	}
	
	@Override
	public Optional<PatrimonioEntity> findById(String id) {
		return patrimonioRepository.findById(Long.valueOf(id).longValue());
		
	}
	
	@Override
	public PatrimonioEntity save(PatrimonioEntity patrimonio)  {
		return patrimonioRepository.save(patrimonio);
	}
	

	@Override
	public void Delete(String Id) {
		patrimonioRepository.deleteById(Long.valueOf(Id).longValue());;
	}

	@Override
	public Page<PatrimonioEntity> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.patrimonioRepository.findAll(pages);
	}



	
}
