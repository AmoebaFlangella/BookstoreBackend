package com.bookstore.demo.web;

import com.bookstore.demo.domain.Book;
import com.bookstore.demo.domain.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {
	
	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> bookList = bookRepository.findAll();

        model.addAttribute("bookList", bookList);

        return "booklist";
    }
}