package com.api.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.entities.Book;

//@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {

	public Book findById(int id);
}
