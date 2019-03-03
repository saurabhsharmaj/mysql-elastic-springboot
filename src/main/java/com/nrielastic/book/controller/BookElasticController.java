package com.nrielastic.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nrielastic.book.model.Book;
import com.nrielastic.book.service.BookElasticService;

@RestController
public class BookElasticController {
	
	@Autowired
	private BookElasticService bookService;

	Integer id =0;
	
	@PostMapping("/adde")
	public @ResponseBody Book adde(@RequestBody Book book) {		
		return bookService.save(book);
	}
	
	
	@GetMapping("/gete")
	public @ResponseBody Iterable<Book> gete() {			
		return bookService.findAll();
		
	}
	
	@PostMapping("/get/author")
	public @ResponseBody Iterable<Book> get(@RequestBody Book book) {
		Page<Book> books = bookService.findByAuthor(book.getAuthor(), new PageRequest(0, 10));	
		return books;
	}
	
}
