package com.siit.j5.bookstore.presentation;

import com.siit.j5.bookstore.data.LibraryRepository;
import com.siit.j5.bookstore.data.LibraryRepositoryImpl;
import com.siit.j5.bookstore.domain.Library;
import com.siit.j5.bookstore.domain.LibraryImpl;

public class Main {
	
	public static void main(String[] args) {
		LibraryRepository libraryRepository = new LibraryRepositoryImpl();
		Library library = new LibraryImpl(libraryRepository);
	}

}
