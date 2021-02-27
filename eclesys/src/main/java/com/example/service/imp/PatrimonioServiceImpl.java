package com.example.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.PatrimonioEntity;
import com.example.repository.PatrimonioRepository;
import com.example.service.PatrimonioService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Service
public class PatrimonioServiceImpl implements PatrimonioService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2307605913625283530L;
	
	@Autowired
	PatrimonioRepository patrimonioRepository;

	@Override
	public List<PatrimonioEntity> findByDescricao(String descricao) throws InvalidFieldException {
		return patrimonioRepository.findByDescricao(descricao);
	}

	@Override
	public List<PatrimonioEntity> findByLocalizacao(String localizacao) throws InvalidFieldException {
		return patrimonioRepository.findByLocalizacao(localizacao);
	}

	@Override
	public PatrimonioEntity save(PatrimonioEntity patrimonio) throws InvalidFieldException {
		return patrimonioRepository.save(patrimonio);
	}

	
}
