package com.nrielastic.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nrielastic.book.model.Book;
import com.nrielastic.book.service.BookDataStoreService;

@RestController
public class BookDataController {
	
	@Autowired
	BookDataStoreService bookDataStoreService;
	
	Integer id =0;
	
	
	@PostMapping("/addp")
	public @ResponseBody int addp(@RequestBody Book book) throws Exception {		
		return bookDataStoreService.insertBook(book);
	}
		
	@GetMapping("/getp")
	public @ResponseBody List<Book> getp() {
		return bookDataStoreService.findAll();
		
	}
	
}
