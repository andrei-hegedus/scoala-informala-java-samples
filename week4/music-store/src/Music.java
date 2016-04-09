import java.util.Comparator;

public class Music implements Comparable<Music>{
    private String artist;
    private String title;
    private int year;
    private Genre genre;
    private Format format;
    
    public static final Comparator<Music> COMPARATOR_BY_ARTIST = new Comparator<Music>() {
		
		@Override
		public int compare(Music o1, Music o2) {
			return o1.artist.compareTo(o2.artist);
		}
	};
    
    public Music(String artist, String title, int year, Genre genre, Format format){
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.format = format;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }
    
    public Genre getGenre() {
        return genre;
    }
    
    public Format getFormat() {
        return format;
    }
    
    @Override
    public String toString() {
        return "["+getYear()+"] "+getArtist()+" - "+getTitle();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (!(o instanceof Music)) {
          return false;
        }

        Music music = (Music) o;

        if (year != music.year) {
          return false;
        }
        if (artist != null ? !artist.equals(music.artist) : music.artist != null) {
          return false;
        }
        if (title != null ? !title.equals(music.title) : music.title != null) {
          return false;
        }
        if (genre != music.genre) {
          return false;
        }
        return format == music.format;

    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }
    
    public enum Format {
        CD, VINYL, CASETTE;
    }
    
    public enum Genre {
        METAL, ROCK, POP, BLUES, RAP, DISCO;
    }

	@Override
	public int compareTo(Music o) {
		return this.title.compareTo(o.title);
	}
}