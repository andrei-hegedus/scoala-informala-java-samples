package ro.siit.g5.io;

public class Novel extends Book {
	
	private static final long serialVersionUID = 1L;
	
	private Genre genre;

	public Novel(String author, String title, Genre genre) {
		super(author, title);
		this.genre = genre;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	
	
	@Override
	public String toString() {
		return "Novel [genre=" + genre + ", author=" + getAuthor() + ", title=" + getTitle() + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Novel other = (Novel) obj;
		if (genre != other.genre)
			return false;
		return true;
	}





	public static enum Genre {
		SCI_FI, FANTASY, HISTORY, POETRY, FICTION, BIOGRAPHY
	}

}
