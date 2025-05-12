package com.pooja.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.springboot.entity.Book;
import com.pooja.springboot.entity.User;
import com.pooja.springboot.repository.BookRepository;
import com.pooja.springboot.repository.UserRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	public boolean save(Book b) {
		try {
			bookRepository.save(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	public boolean deleteById(int id) {
		try {
			bookRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void addBookToMyBookList(int userId, Book book) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!")); // Fetch
																												// user
																												// or
																												// throw
																												// exception
		book.setUser(user); // Associate the book with the user
		user.getMyBookList().add(book); // Add the book to the user's book list
		bookRepository.save(book); // Save the book in the database
	}


}
