package com.nrielastic.book.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nrielastic.book.batch.Processor;
import com.nrielastic.book.batch.Reader;
import com.nrielastic.book.batch.Writer;
import com.nrielastic.book.listener.JobCompletionListener;
import com.nrielastic.book.model.Book;
import com.nrielastic.book.service.BookDataStoreService;
import com.nrielastic.book.service.BookElasticService;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	BookDataStoreService bookDataStoreService;
	
	@Autowired
	private BookElasticService bookService;
	
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<Book, Book> chunk(1)
				.reader(new Reader(bookDataStoreService)).processor(new Processor())
				.writer(new Writer(bookService)).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
