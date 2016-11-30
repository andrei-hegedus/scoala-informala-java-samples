package com.siit.j5.bookstore.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.siit.j5.bookstore.data.Book;
import com.siit.j5.bookstore.data.Client;
import com.siit.j5.bookstore.data.LibraryRepository;

// Unit Test
public class LibraryImplTest {
	
	@Test(expected=IllegalArgumentException.class) // then
	public void whenClientExists_RegistrationFails(){
		// given
		Client client = new Client();
		//LibraryRepository mockedRepo = new OneClientRepo(client);
		LibraryRepository mockedRepo = Mockito.mock(LibraryRepository.class);
		
		List<Client> oneClientList = Arrays.asList(new Client[] {client});
		Mockito.when(mockedRepo.getAllClients()).thenReturn(oneClientList);
		
		LibraryImpl libraryImpl = new LibraryImpl(mockedRepo);
		// when
		libraryImpl.register(client);
	}
	
	@Test
	public void whenClientNotInRepo_RegistrationIsSuccessful(){
		// given
		Client client = new Client();
		LibraryRepository mockedRepo = Mockito.mock(LibraryRepository.class);
		
		Mockito.when(mockedRepo.getAllClients()).thenReturn(Collections.emptyList());
		
		LibraryImpl libraryImpl = new LibraryImpl(mockedRepo);
		// when
		libraryImpl.register(client);
		// then
		Mockito.verify(mockedRepo).addClient(client);
	}
	
	@Test
	public void whenSearchingByTitle_correctSearchResultReturned(){
		// given
		LibraryRepository repo = Mockito.mock(LibraryRepository.class);
		Book book1 = new Book("Title1", "Author1");
		Book book2 = new Book("Title1", "Author2");
		Book book3 = new Book("Title1", "Author3");
		Book book4 = new Book("Title2", "Author1");
		List<Book> books = Arrays.asList(new Book [] {book1, book2, book3, book4});
		Mockito.when(repo.getAllBooks()).thenReturn(books);
		LibraryImpl library = new LibraryImpl(repo);

		// when
		List<Book> booksByTitle = library.findByTitle("Title1");
		
		// then
		Assert.assertEquals(Arrays.asList(new Book [] {book1, book2, book3}), booksByTitle);
	}
	
	
	/*
	private class OneClientRepo implements LibraryRepository {
		
		private Client client;
		
		public OneClientRepo(Client client) {
			this.client = client;
		}

		@Override
		public void removeClient(Client client) {
		}
		
		@Override
		public void removeBook(Book book) {
			
		}
		
		@Override
		public List<Client> getAllClients() {
			ArrayList<Client> clients = new ArrayList<>();
			clients.add(client);
			return clients;
		}
		
		@Override
		public void addClient(Client client) {
			throw new IllegalStateException();
		}
		
		@Override
		public void addBook(Book newBook) {
		}
	};
*/
}
