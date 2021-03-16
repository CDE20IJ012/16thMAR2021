package com.demo.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.cts.model.Book;
import com.demo.cts.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/")
	public String insertBook()
	{
		return "insert";
	}
	
	@PostMapping("/bookadd")
	public String bookAdd(Model map,  @RequestParam String title)
	{
	      Book book=new Book(); // model object
	      book.setBookTitle(title);
	      book=bookService.addBook(book);
	     // System.out.println(book.getBookId());
	      System.out.println(book.getBookTitle());
	      System.out.println(book);
	      map.addAttribute("bookdetails", book);
	      return "success";
	      
	}
}
