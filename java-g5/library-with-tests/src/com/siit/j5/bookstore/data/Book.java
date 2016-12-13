package com.siit.j5.bookstore.data;

public class Book {
	
	private String title;
	private String author;
	private boolean available = true;
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isAvailable() {
		return available;
	}

}
