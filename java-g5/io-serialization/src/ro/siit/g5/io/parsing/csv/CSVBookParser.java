package ro.siit.g5.io.parsing.csv;

import ro.siit.g5.io.Book;

interface CSVBookParser<T extends Book> {
	
	T parseBook(String source);
	
	String getParsedTypeName();

}
