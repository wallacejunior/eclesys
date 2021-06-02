package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.entity.UsuarioEntity;
import com.example.enums.ProfileEnum;
import com.example.repository.UsuarioRepository;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
@EntityScan(basePackages = {"com.example.entity"})
public class IgrejaAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(IgrejaAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
		return args -> {
			initUsers(usuarioRepository, passwordEncoder);
		};
	}
	
	private void initUsers(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
		UsuarioEntity admin = new UsuarioEntity();
		admin.setEmail("admin@eclesys.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		UsuarioEntity find = usuarioRepository.findByEmail("admin@eclesys.com");
		if(find == null){
			usuarioRepository.save(admin);
		}
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}

}
