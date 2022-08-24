package com.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.entities.Book;
import com.api.rest.service.BookService;

@RestController
public class BookController {

	/* @RequestMapping(value = "/books" , method = RequestMethod.GET) */
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("/books") public Book getBooks() { Book book = new Book();
	 * book.setAuthor("Shakespere"); book.setId(8686);
	 * book.setTitle("Return of Dumberdoar"); return book; }
	 */

	/* Getting the List */
	@Autowired
	private BookService bookService;

	/* Get all books */
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> lst = bookService.getAllBooks();
		if (lst.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(lst);
	}

	/* Get single Book */
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(book));
		}
	}

	/* adding the books */
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null; 
		try {
			b = this.bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			this.bookService.deleteBooks(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updatBook(@RequestBody Book book , @PathVariable ("bookId") int bookId)
	{
		try {
			this.bookService.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
