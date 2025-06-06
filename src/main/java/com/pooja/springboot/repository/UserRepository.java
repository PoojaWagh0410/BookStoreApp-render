package com.pooja.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailAndPassword(String email, String password);

	Optional<User> findById(int userId);

}
