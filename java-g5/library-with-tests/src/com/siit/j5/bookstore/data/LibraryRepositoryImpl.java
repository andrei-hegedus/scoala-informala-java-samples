package com.siit.j5.bookstore.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryRepositoryImpl implements LibraryRepository{
	
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<Client> clients = new ArrayList<>();
	private HashMap<Book, Client> lendings =new HashMap<>();

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

	@Override
	public Map<Book, Client> getAllLendings() {
		return Collections.unmodifiableMap(lendings);
	}

	@Override
	public void lendBookToClient(Book book, Client client) {
		lendings.put(book, client);
	}

}
