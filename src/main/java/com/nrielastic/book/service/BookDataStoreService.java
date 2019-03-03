package com.nrielastic.book.service;

import java.util.List;

import com.nrielastic.book.model.Book;

public interface BookDataStoreService {

  public int insertBook(Book book) throws Exception;

	public List<Book> findAll();

	public Book findById(long id);

	public int deleteById(long id);

	public int update(Book book);

}
