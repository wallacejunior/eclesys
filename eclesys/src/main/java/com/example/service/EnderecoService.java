package com.example.service;

import java.io.Serializable;

import com.example.entity.EnderecoEntity;
import com.example.entity.PessoaEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

public interface EnderecoService extends Serializable{

	
	EnderecoEntity save(EnderecoEntity endereco) throws InvalidFieldException;
}

