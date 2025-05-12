package com.pooja.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.springboot.entity.Book;
import com.pooja.springboot.entity.User;
import com.pooja.springboot.repository.BookRepository;
import com.pooja.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User authUser(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return user;
		} else
			return null;
	}

	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		if (users.size() > 0)
			return users;
		else
			return null;
	}

	public List<Book> allBooks() {
		List<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}

	public Optional<User> findUserById(int userId) {
		return userRepository.findById(userId);
	}

	

}
