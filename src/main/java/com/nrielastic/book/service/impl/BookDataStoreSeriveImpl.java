package com.nrielastic.book.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrielastic.book.model.Book;
import com.nrielastic.book.repository.BookDataStoreRepository;
import com.nrielastic.book.service.BookDataStoreService;


@Service
public class BookDataStoreSeriveImpl implements BookDataStoreService {


    @Autowired
    private BookDataStoreRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookDataStoreSeriveImpl.class);

    @Override
    public int insertBook(Book book) throws Exception {
       return bookRepository.insertBook(book);
    }

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {
		return bookRepository.findById(id);
	}

	@Override
	public int deleteById(long id) {
		return bookRepository.deleteById(id);
	}

	@Override
	public int update(Book book) {
		return bookRepository.update(book);
	}
}
