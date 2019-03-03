package com.nrielastic.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nrielastic.book.model.Book;

import java.util.List;

public interface BookElasticRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

}