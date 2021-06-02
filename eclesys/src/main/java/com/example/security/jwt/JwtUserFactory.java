package com.example.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.entity.UsuarioEntity;
import com.example.enums.ProfileEnum;

public class JwtUserFactory {

	private JwtUserFactory(){
		
	}
	
	public static JwtUser create(UsuarioEntity user){
		return new JwtUser(user.getId().toString(),
				user.getEmail(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getProfile()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
