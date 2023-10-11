package com.bookstore.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.demo.domain.Book;
import com.bookstore.demo.domain.BookRepository;
import com.bookstore.demo.domain.CategoryRepository;
import com.bookstore.demo.domain.Category;
import com.bookstore.demo.domain.AppUser;
import com.bookstore.demo.domain.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository appUserRepository) {
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
			
			AppUser u1 = new AppUser("RealPerson", "$2a$10$Ik9/lDEeYn1gf5LIX.UFp.I6qD3yu2duhCdM/J/tmxRp60gUmG8CG", "realperson@gmail.com", "USER");
			AppUser u2 = new AppUser("FakePerson","$2a$10$TbXn2GWBk7.ZloL3J41MS.pCz4ybg5h4iGX9C3Fiho1Qa76yDgohK", "fakeperson@gmail.com", "ADMIN");
			AppUser u3 = new AppUser("Test", "$2a$10$ohu1s8WJVa.LBiuR9CUBUeL68W4/SEohwF5UKrEaVnlg6EBn7TDRm", "test@gmail.com", "USER");
			AppUser u4 = new AppUser("Admin", "$2a$10$87BxdEB4P9Pe5iYt7Pjyh.7J78huIPjYRF3Ur5tzj7lybxBiT87Ti", "admin@gmail.com", "ADMIN");
			
			appUserRepository.save(u1);
			appUserRepository.save(u2);
			appUserRepository.save(u3);
			appUserRepository.save(u4);
			
		};
	}
}
