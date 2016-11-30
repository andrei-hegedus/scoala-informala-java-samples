package com.siit.j5.bookstore.domain;

import java.util.List;

import com.siit.j5.bookstore.data.Book;
import com.siit.j5.bookstore.data.Client;

public interface Library {
	
	void register(Client newClient);
	
	List<Book> showAllBooks();
	
	List<Book> findByTitle(String title);
	
	void lend(Book book, Client client);

}
