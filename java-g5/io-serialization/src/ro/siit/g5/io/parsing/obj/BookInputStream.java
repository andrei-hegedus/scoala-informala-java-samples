package ro.siit.g5.io.parsing.obj;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import ro.siit.g5.io.Book;

public class BookInputStream extends ObjectInputStream {
	
	private InputStream in;

	public BookInputStream(InputStream in) throws IOException {
		super(in);
		this.in = in;
	}
	
	public List<Book> readBooks() throws ClassNotFoundException, IOException{
		ArrayList<Book> books = new ArrayList<>();
		int available = in.available();
		while(available>0){
			Object obj = readObject();
			books.add((Book) obj);
			available = in.available();
		}
		return books;
		
	}

}
