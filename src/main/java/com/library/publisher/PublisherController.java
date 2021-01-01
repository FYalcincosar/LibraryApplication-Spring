package com.library.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PublisherController {

	@Autowired
	private PublisherService service;
	
	@Autowired
	private PublisherRepository repository;
	
	@GetMapping("/publishers")
	public String listPublishers(Model model) {
		
		List<Publisher>listPublishers=repository.findAll();
		
		model.addAttribute("listPublishers",listPublishers);
		
		return "publishers";
	}
	@GetMapping("/publishers/new")
	public String showPublisherAddForm(Model model) {
		
		model.addAttribute("publisher",new Publisher());
		
		return "publisher_form";
	}
	@PostMapping("/publishers/add")
	public String addPublisher(Publisher publisher) {
		
		service.getPublisherIfRecordExist(publisher);
		
		System.out.println("pub test: "+publisher.getId());
		
		service.save(publisher);
		
		return "redirect:/publishers";
	}
	@GetMapping("publishers/info/{id}")
	public String showPublisherInfo(@PathVariable("id")Integer id,Model model) {
		
		model.addAttribute("publisher",service.getPublisherById(id));
		return "publisher_info";
	}
	@GetMapping("publishers/edit/{id}")
	public String showEditPublisherForm(@PathVariable("id")Integer id,Model model) {
		
		model.addAttribute("publisher",service.getPublisherById(id));
		return "publisher_edit_form";
	}
	
	@PostMapping("/publishers/update")
	public String updateAuthor(Publisher publisher) {
		service.save(publisher);
		
		return "redirect:/publishers";
	}
	@GetMapping("publishers/delete/{id}")
	public String deleteBook(@PathVariable("id")Integer id,Model model) {
		
		service.deletePublisher(id);
		
		return "redirect:/publishers";
	}
}
