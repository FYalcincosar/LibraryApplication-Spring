package com.library.author;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.publisher.Publisher;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository repository;
	
	
	
	public void getAuthorIfRecordExist(Author aut){
		if(aut.getAuthorName()!=null && !repository.search(aut.getAuthorName()).isEmpty()) {
			
			aut.setId(repository.search(aut.getAuthorName()).get(0).getId()); 
			
			aut.setDescription(aut.getDescription());
		}
		else
			aut.setId(new Publisher().getId());
		
	}
	public void save(Author aut) {
		System.out.println("debug save: "+aut.getId());
		
		repository.save(aut);
	}
	
	public List<Author>getAllAuthors(){
		
		return repository.findAll();
	}
	
	public Author getAuthorById(Integer id) {

		return repository.findById(id).get();
	}
	public void deleteAuthor(Integer id) {
		
		repository.deleteById(id);
	}
}
