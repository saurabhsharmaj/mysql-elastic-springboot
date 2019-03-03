package com.nrielastic.book.batch;

import org.springframework.batch.item.ItemProcessor;

import com.nrielastic.book.model.Book;

public class Processor implements ItemProcessor<Book, Book> {

	@Override
	public Book process(Book book) throws Exception {
		return book;
	}

}
