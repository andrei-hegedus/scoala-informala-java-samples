package ro.siit.g5.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import ro.siit.g5.io.ArtAlbum.PageQuality;
import ro.siit.g5.io.parsing.csv.CSVBookReader;

public class Main {
	
	static HashMap<Class<? extends Book>, BookMethodsExecutor> executors = new HashMap<>();
	static {
		executors.put(Novel.class, new NovelMethodsExecutor());
		executors.put(ArtAlbum.class, new ArtAlbumExecutor());
	}
	
	public static void main(String[] args) throws IOException {
		File csv = new File("/Users/andrei/TEACH/eclipse/workspace/G5IO_serialization/books.csv");
		try(CSVBookReader reader = new CSVBookReader(Files.newBufferedReader(csv.toPath()))){
			List<Book> books = reader.readBooks();
			books.add(new ArtAlbum("Album", "Album", PageQuality.THICK_NORMAL));
			for(Book b:books){
				System.out.println(b.toString());
				BookMethodsExecutor e = executors.get(b.getClass());
				e.execute(b);
			}
		}
	}
	
	public interface BookMethodsExecutor {
		void execute(Book book);
	}
	
	static class NovelMethodsExecutor implements BookMethodsExecutor {
		@Override
		public void execute(Book book) {
			System.out.println(((Novel)book).getGenre());
		}
	}
	
	static class ArtAlbumExecutor implements BookMethodsExecutor {
		@Override
		public void execute(Book book) {
			System.out.println(((ArtAlbum)book).getPageQuality());
		}
	}

}
