package com.siit.j5.bookstore.data;

import java.util.List;

public interface LibraryRepository {
	
	void removeBook(Book book);
	void addBook(Book newBook);
	void addClient(Client client);
	void removeClient(Client client);
	List<Client> getAllClients();
	List<Book> getAllBooks();
}
