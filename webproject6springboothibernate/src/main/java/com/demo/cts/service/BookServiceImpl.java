package com.demo.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cts.model.Book;
import com.demo.cts.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(Book book) {
		 bookRepository.save(book);
		
		return book; 
	}

}
