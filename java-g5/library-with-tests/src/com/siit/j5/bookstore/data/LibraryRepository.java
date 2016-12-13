package com.siit.j5.bookstore.data;

import java.util.List;
import java.util.Map;

public interface LibraryRepository {
	
	void removeBook(Book book);
	void addBook(Book newBook);
	void addClient(Client client);
	void removeClient(Client client);
	List<Client> getAllClients();
	List<Book> getAllBooks();
	Map<Book, Client> getAllLendings();
	void lendBookToClient(Book book, Client client);
}
