package com.bookstore.demo.web;

import com.bookstore.demo.domain.Book;
import com.bookstore.demo.domain.BookRepository;
import com.bookstore.demo.domain.Category;
import com.bookstore.demo.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
		this.bookRepository = bookRepository;
		this.categoryRepository = categoryRepository;
	}
	

	@GetMapping("/booklist")
	public String showBookList(Model model) {
		Iterable<Book> bookList = bookRepository.findAll();

		model.addAttribute("bookList", bookList);

		return "booklist";
	}

	@GetMapping("/addbook")
	public String showAddBookForm(Model model) {
		model.addAttribute("book", new Book());
		Iterable<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "addbook";
	}

	@PostMapping("/addbook")
	public String addBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}

	@GetMapping("/editbook/{id}")
	public String editingBook(@PathVariable Long id, Model model) {
		Optional<Book> book = bookRepository.findById(id);
		model.addAttribute("book", book.get());
		return "editbook";
	}

	@PostMapping("/editingpage")
	public String editingPage(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findStudentRest(@PathVariable Long id){
		return bookRepository.findById(id);
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}