package com.pooja.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.springboot.entity.BookList;
import com.pooja.springboot.repository.BookListRepository;

@Service
public class BookListService {
	
	@Autowired
	private BookListRepository bookListRepository;
	
	public void saveMyBooks(BookList book) {
		bookListRepository.save(book);
	}
	
	public List<BookList> getAllMyBooks(){
		return bookListRepository.findAll();
	}
	
	public void deleteById(int id) {
		bookListRepository.deleteById(id);
	}

	

	

}
