package com.example.service;

import java.io.Serializable;

import com.example.entity.DepartamentoEntity;
import com.igrejaApp.Exceptions.InvalidFieldException;

public interface DepartamentoService extends Serializable{

	
	 DepartamentoEntity save(DepartamentoEntity departamento) throws InvalidFieldException;
}
