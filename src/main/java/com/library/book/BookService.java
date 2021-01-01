package com.library.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.author.AuthorService;
import com.library.publisher.PublisherService;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private PublisherService publisherservice;
	
	public List<Book>listAll(String keyword){
		if(keyword!=null) {
			return repository.search(keyword);
		}
		return repository.findAll();
	}
	
	public Book getBookById(Integer id) {

		return repository.findById(id).get();
	}
	
	public void deleteBook(Integer id) {
		repository.deleteById(id);
	}
	public void checkAndSave(Book book) {
		
		authorService.getAuthorIfRecordExist(book.getAuthor());
		
		authorService.save(book.getAuthor());
		
		publisherservice.getPublisherIfRecordExist(book.getPublisher());
		
		publisherservice.save(book.getPublisher());
		
		save(book);
		
	}
	
	public void save(Book book) {
		repository.save(book);
	}
}
