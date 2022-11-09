package com.SpringSecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SpringSecurity.Security.Model.User;
import com.SpringSecurity.Security.Repository.UserRepository;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	public class SpringHelloWorldApplication {
		public void main(String[] args) {
		SpringApplication.run((Class)null, args);
		}
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		User user= new User();
		user.setEmail("abhishek888@gmail.com");
		user.setUsername("Amansingh12");
		user.setPassword(this.passwordEncoder.encode("AABBCC"));
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);
		
		User user1= new User();
		user1.setEmail("admin@admin.com");
		user1.setUsername("Admin");
		user1.setPassword(this.passwordEncoder.encode("admin"));
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
	}
}
