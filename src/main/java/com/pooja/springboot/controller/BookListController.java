package com.pooja.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pooja.springboot.service.BookListService;

@Controller
public class BookListController {

	@Autowired
	private BookListService bookListService;

	@RequestMapping(path = "/deleteMyBook/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		bookListService.deleteById(id);
		return "redirect:/my_books";
	}
}
