package com.siit.j5.bookstore;

import org.junit.Test;

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

}
