package com.bookstore.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.demo.domain.Book;

import com.bookstore.demo.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("FakeBook", "Real Andrew", 2021, "3", 90);
			Book b2 = new Book("RealBook", "Real Mark", 2019, "2", 500);
			Book b3 = new Book("ArmBook", "Not Mark", 2023, "1", 9);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}
}
