package ro.siit.java.mediastore;

/**
 * Created by andreihegedus-sirbu on 04/12/2017.
 */
public class MediaItem {

    public static final String MEDIA_TYPE_AUDIO_BOOK = "Audio Book";
    public static final String MEDIA_TYPE_MUSIC = "Music";
    public static final String MEDIA_TYPE_MOVIE = "Movie";
    public static final String MEDIA_FORMAT_CD = "CD";
    public static final String MEDIA_FORMAT_DVD = "DVD";
    public static final String MEDIA_FORMAT_BLUE_RAY = "BlueRay";

    private String type;
    private String format;

    private String title;
    private int year;

    // TODO add MetaData: author, artist, director


    public MediaItem(String type, String format, String title, int year) {
        this.type = type;
        this.format = format;
        this.title = title;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
