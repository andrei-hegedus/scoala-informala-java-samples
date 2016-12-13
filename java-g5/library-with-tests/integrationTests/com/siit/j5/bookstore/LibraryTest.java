package com.siit.j5.bookstore;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.siit.j5.bookstore.data.Book;
import com.siit.j5.bookstore.data.Client;
import com.siit.j5.bookstore.data.LibraryRepository;
import com.siit.j5.bookstore.data.LibraryRepositoryImpl;
import com.siit.j5.bookstore.domain.LibraryImpl;



// Integration test between LibraryImpl and LibraryRepositoryImpl
public class LibraryTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void whenClientExists_RegistrationFails(){
		// given
		Client client = new Client();
		
		LibraryRepository repo = new LibraryRepositoryImpl();
		repo.addClient(client);
		
		LibraryImpl libraryImpl = new LibraryImpl(repo);
		// when
		libraryImpl.register(client);
	}
	
	@Test
	public void whenBookIsLent_bookShowsAsUnavailableInSearch(){
		// given
		Book b1 = new Book("Huckleberry Finn", "Mark Twain");
		Book b2 = new Book("Ion", "Liviu Rebreanu");
		
		Client c1 = new Client();
		Client c2 = new Client();
		LibraryRepository repo = new LibraryRepositoryImpl();
		repo.addBook(b1);
		repo.addBook(b2);
		repo.addClient(c1);
		repo.addClient(c2);
		LibraryImpl libraryImpl = new LibraryImpl(repo);
		
		// when
		//repo.lendBookToCLient(b2, c1);
		libraryImpl.lend(b2, c1);
		List<Book> books = libraryImpl.showAllBooks();
		// then
		Book assertedBook = null;
		for(Book b : books){
			if(b.getTitle().equals(b2.getTitle())){
				assertedBook = b;
			}
		}
		Assert.assertNotNull(assertedBook);
		Assert.assertFalse(assertedBook.isAvailable());
	}

}
