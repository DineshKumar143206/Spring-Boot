package com.REST_API.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.REST_API.model.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{

	public Books findById(int id);
}
