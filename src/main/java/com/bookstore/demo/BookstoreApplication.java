package com.bookstore.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.demo.domain.Book;

import com.bookstore.demo.domain.BookRepository;
import com.bookstore.demo.domain.CategoryRepository;
import com.bookstore.demo.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			Category c1 = new Category("Horror");
			Category c2 = new Category("Fantasy");
			Category c3 = new Category("Science Fiction");
			
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);
			
			Book b1 = new Book("FakeBook", "Real Andrew", 2021, "3", 90, c1);
			Book b2 = new Book("RealBook", "Real Mark", 2019, "2", 500, c2);
			Book b3 = new Book("ArmBook", "Not Mark", 2023, "1", 9, c3);

			bookRepository.save(b1);
			bookRepository.save(b2);
			bookRepository.save(b3);
		};
	}
}
