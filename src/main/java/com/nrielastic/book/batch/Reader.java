package com.nrielastic.book.batch;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.nrielastic.book.model.Book;
import com.nrielastic.book.service.BookDataStoreService;

public class Reader implements ItemReader<Book> {

	
	BookDataStoreService bookDataStoreService;
	
	

	private int count = 0;

	public Reader(BookDataStoreService bookDataStoreService) {
		this.bookDataStoreService=bookDataStoreService;
	}

	@Override
	public Book read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {	
		
		List<Book> books = bookDataStoreService.findAll();
		
		if (count < books.size()) {
			return books.get(count++);
		} else {
			count = 0;
		}
		return null;
	}

}