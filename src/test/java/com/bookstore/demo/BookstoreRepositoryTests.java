package com.bookstore.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstore.demo.domain.AppUser;
import com.bookstore.demo.domain.AppUserRepository;
import com.bookstore.demo.domain.Book;
import com.bookstore.demo.domain.BookRepository;
import com.bookstore.demo.domain.Category;
import com.bookstore.demo.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookstoreRepositoryTests {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void findBook() {
		List<Book> bookList = bookRepository.findByTitle("RealBook");
		assertThat(bookList).hasSize(1);
		assertThat(bookList.get(0).getTitle()).isEqualTo("FakeBook");
	}
	
	@Test
	public void addBook() {
		Category category = new Category ("Comedy");
		categoryRepository.save(category);
		Book book = new Book("DumbBook", "Dumb Face", 2001, "asf54", 20, category);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> bookList = bookRepository.findByTitle("RealBook");
		Book book = bookList.get(0);
		bookRepository.delete(book);
		List<Book> newBookList = bookRepository.findByTitle("RealBook");
		assertThat(newBookList).hasSize(0);
	}
	
	@Test
	public void findUser() {
		List<AppUser> appUserList = appUserRepository.findByListUsername("Test");
		assertThat(appUserList).hasSize(1);
		assertThat(appUserList.get(0).getUsername()).isEqualTo("RealPerson");
	}
	
	@Test
	public void deleteUser() {
		List<AppUser> userList = appUserRepository.findByListUsername("Test");
		AppUser appUser = userList.get(0);
		appUserRepository.delete(appUser);
		List<AppUser> newAppUserList = appUserRepository.findByListUsername("Test");
		assertThat(newAppUserList).hasSize(0);
	}
	
	@Test
	public void findCategory() {
		List<Category> categoryList = categoryRepository.findByName("Horror");
		assertThat(categoryList).hasSize(1);
		assertThat(categoryList.get(0).getName()).isEqualTo("Horror");
	}
	
	@Test
	public void addCategory() {
		Category category = new Category("Stupid");
		categoryRepository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categoryList = categoryRepository.findByName("Fantasy");
		Category category = categoryList.get(0);
		categoryRepository.delete(category);
		List<Category> newCategoryList = categoryRepository.findByName("Fantasy");
		assertThat(newCategoryList).hasSize(0);
	}
}
