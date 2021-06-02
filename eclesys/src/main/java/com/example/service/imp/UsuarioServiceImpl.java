package com.example.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.UsuarioEntity;
import com.example.repository.UsuarioRepository;
import com.example.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	private static final long serialVersionUID = -1860375621394659534L;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioEntity findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
		
	}
	
	public Optional<UsuarioEntity> findById(String id) {
		return usuarioRepository.findById(id);
		
	}
	

	public UsuarioEntity save(UsuarioEntity nome)	 {
		return usuarioRepository.save(nome);
	}
	
	public UsuarioEntity createOrUpdate(UsuarioEntity usuario)  {
		return usuarioRepository.createOrUpdate(usuario);
	}

	@Override
	public void Delete(String Id) {
		usuarioRepository.deleteById(Id);
	}

	@Override
	public Page<UsuarioEntity> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.usuarioRepository.findAll(pages);
	}

}
