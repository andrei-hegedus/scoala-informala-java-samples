package com.siit.j5.bookstore.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.siit.j5.bookstore.data.Book;
import com.siit.j5.bookstore.data.Client;
import com.siit.j5.bookstore.data.LibraryRepository;

public class LibraryImpl implements Library{
	
	private LibraryRepository libraryRepository;

	public LibraryImpl(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	@Override
	public void register(Client newClient) {
		List<Client> clients = libraryRepository.getAllClients();
		if(clients.contains(newClient)){
			throw new IllegalArgumentException("Client already registered");
		}
		libraryRepository.addClient(newClient);
	}

	@Override
	public List<Book> showAllBooks() {
		return libraryRepository.getAllBooks();
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> books = libraryRepository.getAllBooks();
		ArrayList<Book> filteredBooks = new ArrayList<>();
		for(Book book : books){
			if(book.getTitle().equals(title)){
				filteredBooks.add(book);
			}
		}
		return filteredBooks;
	}

	@Override
	public void lend(Book book, Client client) {
		libraryRepository.lendBookToClient(book, client);
		book.setAvailable(false);
	}
	
	

}
