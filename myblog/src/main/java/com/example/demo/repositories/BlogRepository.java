package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface BlogRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByPassword(String password);
	List<User> findAllByPassword(String password);
	User findAllByUsernameIsNotNullAndPasswordIsNotNull();
	
	@Query(value = "DELETE FROM account WHERE username = ?1", nativeQuery = true)
	void deleteByUsername(String username);
}
