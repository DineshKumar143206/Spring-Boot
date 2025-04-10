package com.REST_API.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.REST_API.model.Books;
import com.REST_API.services.BooksService;

@RestController
public class MainController {
	
	private BooksService booksService;
	
	@GetMapping("/books")
	public List<Books> getBooks() {
		
		List<Books> books =  booksService.getAllBooks();
		return books;
	}
	
	@PostMapping("/books")
	public void createBook(Books b) {
		
		Books books = new Books();
		books.setId(1);
		books.setTitle("GOT");
		books.setAuthor("Dinesh");
		booksService.saveBooks(books);
	}

}
