package com.bookstore.demo.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;
	private double price;
	
    public Book() {
    }
	
	public Book (String title, String author, int publicationYear, String isbn, double price) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Long getId () {
		return id;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor (String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setPublicationYear (int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}
	
	public void setIsbn (String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setPrice (double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
