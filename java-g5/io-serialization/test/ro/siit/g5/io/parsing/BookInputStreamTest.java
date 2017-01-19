package ro.siit.g5.io.parsing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.junit.Test;

import ro.siit.g5.io.Book;
import ro.siit.g5.io.Novel;
import ro.siit.g5.io.Novel.Genre;
import ro.siit.g5.io.parsing.obj.BookInputStream;

public class BookInputStreamTest {
	
	@Test
	public void whenParsingCSVList_withOneNovel_shouldReturnBookList_ofOneNovel() throws IOException, ClassNotFoundException {
		Novel expected = new Novel("J.R.R Tolkien", "The Hobbit", Genre.FANTASY);
		byte [] serializedNovel = null;
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)){
			oos.writeObject(expected);
			oos.flush();
			oos.close();
			serializedNovel = baos.toByteArray();
		}
		try(BookInputStream bis = new BookInputStream(new ByteArrayInputStream(serializedNovel))){
			List<Book> books = bis.readBooks();
			assertEquals(1, books.size());
			assertEquals(expected, books.get(0));
		}
		
	}
	
	@Test
	public void whenParsingCSVList_withTwoNovels_shouldReturnBookList_ofTwoNovels() throws IOException, ClassNotFoundException {
		Novel n1 = new Novel("J.R.R Tolkien", "The Hobbit", Genre.FANTASY);
		Novel n2 = new Novel("Agatha Christie", "ABC Murders", Genre.FICTION);
		byte [] serializedNovel = null;
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)){
			oos.writeObject(n1);
			oos.writeObject(n2);
			oos.flush();
			oos.close();
			serializedNovel = baos.toByteArray();
		}
		try(BookInputStream bis = new BookInputStream(new ByteArrayInputStream(serializedNovel))){
			List<Book> books = bis.readBooks();
			assertEquals(2, books.size());
			Book[] expected = new Book[]{n1, n2};
			Book[] actual = new Book[2];
			books.toArray(actual);
			assertArrayEquals(expected, actual);
		}
	}
	

}
