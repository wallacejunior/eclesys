package com.example.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.UsuarioEntity;
import com.example.repository.UsuarioRepository;
import com.example.service.UsuarioService;
import com.igrejaApp.Exceptions.InvalidFieldException;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	private static final long serialVersionUID = -1860375621394659534L;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public List<UsuarioEntity> findByNome(String nome) throws InvalidFieldException {
		return usuarioRepository.findByNome(nome);
		
	}

	@Override
	@Transactional
	public UsuarioEntity save(UsuarioEntity nome) throws InvalidFieldException {
		return usuarioRepository.save(nome);
	}

}
