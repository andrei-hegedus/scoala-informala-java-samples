package ro.siit.g5.io.parsing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import ro.siit.g5.io.Book;
import ro.siit.g5.io.Novel;
import ro.siit.g5.io.Novel.Genre;
import ro.siit.g5.io.parsing.csv.CSVBookReader;

// Integration Test
public class CSVBookParsingTest {

	@Test
	public void whenParsingCSVList_withOneNovel_shouldReturnBookList_ofOneNovel() throws IOException {
		String csv = "Novel,J.R.R Tolkien,The Hobbit,FANTASY\n";
		StringReader sr = new StringReader(csv);
		try (CSVBookReader bookReader = new CSVBookReader(sr)) {
			List<Book> books = bookReader.readBooks();
			assertEquals(1, books.size());
			Novel expected = new Novel("J.R.R Tolkien", "The Hobbit", Genre.FANTASY);
			assertEquals(expected, books.get(0));
		}
	}
	
	@Test
	public void whenParsingCSVList_withTwoNovels_shouldReturnBookList_ofTwoNovels() throws IOException {
		String csv = "Novel,J.R.R Tolkien,The Hobbit,FANTASY\n"
				+ "Novel,Agatha Christie,ABC Murders,FICTION\n";
		StringReader sr = new StringReader(csv);
		try (CSVBookReader bookReader = new CSVBookReader(sr)) {
			List<Book> books = bookReader.readBooks();
			assertEquals(2, books.size());
			Novel n1 = new Novel("J.R.R Tolkien", "The Hobbit", Genre.FANTASY);
			Novel n2 = new Novel("Agatha Christie", "ABC Murders", Genre.FICTION);
			Book[] expected = new Book[]{n1, n2};
			Book[] actual = new Book[2];
			books.toArray(actual);
			assertArrayEquals(expected, actual);
		}
	}

}
