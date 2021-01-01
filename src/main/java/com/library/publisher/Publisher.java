package com.library.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.library.book.Book;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=50,nullable=false,unique=true)
	private String publisherName;
	private String description;
	@OneToMany(mappedBy = "publisher",cascade=CascadeType.ALL)
	private List<Book> books=new ArrayList<Book>();
	
	public Publisher() {
		
	}
	
	public Publisher(Integer id) {
		this.id = id;
	}
	
	public Publisher(String publisherName,String description) {
		this.publisherName = publisherName;
		this.description = description;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	
}
