package com.nrielastic.book.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.nrielastic.book.model.Book;
import com.nrielastic.book.service.BookElasticService;

public class Writer implements ItemWriter<Book> {

	
	private BookElasticService bookService;
	
	public Writer(BookElasticService bookService) {
		this.bookService=bookService;
	}

	@Override
	public void write(List<? extends Book> books) throws Exception {
		for (Book book : books) {
			bookService.save(book);
		}
	}

}