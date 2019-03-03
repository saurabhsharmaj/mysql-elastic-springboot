package com.nrielastic.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.nrielastic.book.model.Book;

import java.util.List;

public interface BookElasticService {

    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);

}