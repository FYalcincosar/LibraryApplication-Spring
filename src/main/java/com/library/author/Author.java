package com.library.author;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.library.book.Book;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length=40, nullable=false,unique=true)
	private String authorName;
	private String description;
	@OneToMany(mappedBy = "author",cascade=CascadeType.ALL)
	private List<Book> books=new ArrayList<Book>();
	
	public Author() {
	}
	
	
	 public Author(Integer id) {
		 
		 this.id = id;
	 }	
	 
	public Author(String authorName,String description) {
		this.authorName = authorName;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
