package com.siit.j5.bookstore.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryRepositoryImpl implements LibraryRepository{
	
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<Client> clients = new ArrayList<>();

	@Override
	public void removeBook(Book book) {
		books.remove(book);
	}

	@Override
	public void addBook(Book newBook) {
		books.add(newBook);
	}

	@Override
	public void addClient(Client client) {
		clients.add(client);
	}

	@Override
	public void removeClient(Client client) {
		clients.remove(client);
	}

	@Override
	public List<Client> getAllClients() {
		return Collections.unmodifiableList(clients);
	}

	@Override
	public List<Book> getAllBooks() {
		return Collections.unmodifiableList(books);
	}

}
