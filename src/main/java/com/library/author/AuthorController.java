package com.library.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService service; 
	
	@GetMapping("/authors")
	public String listAuthors(Model model) {
		
		model.addAttribute("listAuthors",service.getAllAuthors());
		return "authors";
	}
	
	@GetMapping("/authors/new")
	public String showAuthorAddForm(Model model) {
		model.addAttribute("author",new Author());
		
		return "author_form";
	}
	
	@PostMapping("/authors/add")
	public String addAuthor(Author author) {
		
		service.setAuthorIfRecordExist(author);
		service.save(author);
		return "redirect:/authors";
	}
	
	@GetMapping("authors/edit/{id}")
	public String showEditAuthorForm(@PathVariable("id")Integer id,Model model) {
		
		model.addAttribute("author",service.getAuthorById(id));
		return "author_edit_form";
	}
	@GetMapping("authors/info/{id}")
	public String showAuthorInfo(@PathVariable("id")Integer id,Model model) {
		
		model.addAttribute("author",service.getAuthorById(id));
		return "author_info";
	}
	@PostMapping("/authors/update")
	public String updateAuthor(Author author) {

		service.save(author);
		return "redirect:/authors";
	}
	@GetMapping("authors/delete/{id}")
	public String deleteBook(@PathVariable("id")Integer id,Model model) {
		service.deleteAuthor(id);
		
		return "redirect:/authors";
	}
}
