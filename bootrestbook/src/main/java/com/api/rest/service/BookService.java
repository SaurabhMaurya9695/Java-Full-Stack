package com.api.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.rest.dao.BookRepo;
import com.api.rest.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
//	public static List<Book> lst = new ArrayList<>();
//	static {
//		lst.add(new Book(12, "Hey Baby", "Saurabh"));
//		lst.add(new Book(121, "Hey Yash", "Yash"));
//		lst.add(new Book(123, "Hey Saurabh", "Saurabh"));
//		lst.add(new Book(1245, "Hey ! ", "Khadoos"));
//	}

	// get all books;
	public List<Book> getAllBooks() {
		List<Book> lst = (List<Book>) this.bookRepo.findAll();
		return lst;
	}

	// get book by id ;
	public Book getBookById(int id) {
		Book objBook = null;
//		objBook = lst.stream().filter(e -> e.getId() == id).findFirst().get();
		try {
			objBook = this.bookRepo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objBook;
	}

	// adding the book
	public Book addBook(Book b) {
//		lst.add(b);
		Book resBook = bookRepo.save(b);
		return resBook;
	}

	// delete the books
	public void deleteBooks(int id) {
//		lst = lst.stream().filter(book -> {
//			if (book.getId() != id) {
//				return true;
//			} else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		bookRepo.deleteById(id);
	}
	
	//update the books;
	public void updateBook(Book book , int bookId) {
		book.setId(bookId);
		bookRepo.save(book);
	}
}
