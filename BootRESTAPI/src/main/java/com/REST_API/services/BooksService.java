package com.REST_API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.REST_API.model.Books;
import com.REST_API.repo.BooksRepository;

@Component
public class BooksService {
	
	@Autowired
	private BooksRepository booksRepository;

	// get all books
	public List<Books> getAllBooks(){
		
		List<Books> books = (List<Books>) this.booksRepository.findAll();
		return books;
	}
	
	// get book by id
	public Books findById(int id) {
		
		Books book =  this.booksRepository.findById(id);
		return book;
	}
	
	//adding the book
	public Books saveBooks(Books book) {
		
		Books books = this.booksRepository.save(book);
		return books;
	}
	
	// delete book by id
	public void deleteById(int id) {
		
		this.booksRepository.deleteById(id);
	}
	 
	// delete all books
	public void deleteAllBooks() {
		
		this.booksRepository.deleteAll();
	}
	
	// update a book
	public void updateBooks(Books book, int id) {
		
		book.setId(id);
		this.booksRepository.save(book);
	}
}
