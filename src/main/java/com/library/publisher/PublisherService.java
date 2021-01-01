package com.library.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository repository;
	
	public void setPublisherIfRecordExist(Publisher pub){
		if(pub.getPublisherName()!=null && !repository.search(pub.getPublisherName()).isEmpty()) {
			
			System.out.println("debug: "+repository.search(pub.getPublisherName()).get(0).getId());
			
			pub.setId(repository.search(pub.getPublisherName()).get(0).getId()); 
			pub.setDescription(pub.getDescription());
		}
		else
			pub.setId(new Publisher().getId());
		
	}
	

	
	public List<Publisher>getAllPublishers(){
		return repository.findAll();
	}
	
	public Publisher getPublisherById(Integer id) {

		return repository.findById(id).get();
	}
	public void deletePublisher(Integer id) {
		repository.deleteById(id);
	}
	
	
	public void save(Publisher publisher) {
		repository.save(publisher);
	}

}
