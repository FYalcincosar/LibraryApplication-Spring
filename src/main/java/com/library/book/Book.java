package com.library.book;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.library.author.Author;
import com.library.publisher.Publisher;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=100,nullable=false)
	private String bookTitle;
	private String bookSubname;
	private String bookSeriesName;
	private String description;
	@Column(nullable=false)
	private String isbn;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="author_id")
	private Author author;
	//cascade=CascadeType.ALL
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="publisher_id")
	private Publisher publisher;

	public Book() {
		
	}
	
	public Book(Integer id, String bookTitle, String bookSubname, String bookSeriesName, String description,
			String isbn, Author author, Publisher publisher) {
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookSubname = bookSubname;
		this.bookSeriesName = bookSeriesName;
		this.description = description;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookSubname() {
		return bookSubname;
	}

	public void setBookSubname(String bookSubname) {
		this.bookSubname = bookSubname;
	}

	public String getBookSeriesName() {
		return bookSeriesName;
	}

	public void setBookSeriesName(String bookSeriesName) {
		this.bookSeriesName = bookSeriesName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
}
