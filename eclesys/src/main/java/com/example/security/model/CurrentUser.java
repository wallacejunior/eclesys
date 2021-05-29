package com.example.security.model;

import com.example.entity.UsuarioEntity;

public class CurrentUser {

	private String token;
	private UsuarioEntity user;
	
	public CurrentUser (String token, UsuarioEntity user){
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioEntity getUser() {
		return user;
	}

	public void setUser(UsuarioEntity user) {
		this.user = user;
	}
}
