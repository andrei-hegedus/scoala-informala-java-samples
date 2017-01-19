package ro.siit.g5.io.parsing.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import ro.siit.g5.io.Book;

public class CSVBookReader extends BufferedReader {
	
	private CSVBookParserFactory parserFactory = new CSVBookParserFactory();

	public CSVBookReader(Reader in) {
		super(in);
	}
	
	public List<Book> readBooks() throws IOException{
		String line = readLine();
		ArrayList<Book> books = new ArrayList<>();
		while(line!=null){
			String[] tokens = line.split(",");
			String bookType = tokens[0];
			Book book = parserFactory.getParserFor(bookType).parseBook(line);
			books.add(book);
			line = readLine();
		}
		return books;
	}

}
