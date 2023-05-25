package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class BlogService {
	@Autowired
	private UserRepository userRepository;
	private static Logger logger = LoggerFactory.getLogger(BlogService.class);
	
	public boolean isUsernameExist(String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) return false;
		return true;
	}
	
	public boolean isAccountinfoCorrect(String username, String password) {
		
		User user = userRepository.findByUsername(username);
		if (user == null) return false;
		return user.getPassword().equals(password);
	}
	
	public void createNewUser(String username, String password, String email) {
		User user = User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
		userRepository.save(user);
	}
	
//	public boolean validateAccount(String username, String password) {
//		Account account = accountRepository.findByUsername(username);
//		if (account == null || !account.getPassword().equals(password)) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//	
//	public boolean createAccount(String username, String password) {
//		if (accountRepository.findByUsername(username) == null) {
//			accountRepository.save(new Account(username, password));
//			return true;
//		} else {
//			return false;
//		}
//	}
}
