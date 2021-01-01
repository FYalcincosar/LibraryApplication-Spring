package com.library.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {

	
	@Autowired
	private BookService service; 
	
	 @GetMapping("/books")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {

        model.addAttribute("listBook", service.listAll(keyword));
        model.addAttribute("keyword", keyword);
         
        return "books";
	}

	@GetMapping("/books/new")
	public String showBookAddForm(Model model) {

		model.addAttribute("book",new Book());

		return "book_form";
	}
	@PostMapping("/books/add")
	public String addBook(Book book) {

		service.checkAndSave(book);

		return "redirect:/books";
	}
	
	@GetMapping("books/edit/{id}")
	public String showEditBookForm(@PathVariable("id")Integer id,Model model) {
	
		model.addAttribute("book",service.getBookById(id));

		return "book_form";
	}
	
	@GetMapping("books/info/{id}")
	public String showBookInfo(@PathVariable("id")Integer id,Model model) {
		
		model.addAttribute("book",service.getBookById(id));
		return "book_info";
	}
	
	@GetMapping("books/delete/{id}")
	public String deleteBook(@PathVariable("id")Integer id,Model model) {
		
		service.deleteBook(id);
		
		return "redirect:/books";
	}
}
