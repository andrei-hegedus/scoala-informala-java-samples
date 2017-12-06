package ro.siit.java.mediastore;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by andreihegedus-sirbu on 04/12/2017.
 */
public class MediaItem implements Comparable<MediaItem>{

    public static final String MEDIA_TYPE_AUDIO_BOOK = "Audio Book";
    public static final String MEDIA_TYPE_MUSIC = "Music";
    public static final String MEDIA_TYPE_MOVIE = "Movie";
    public static final String MEDIA_FORMAT_CD = "CD";
    public static final String MEDIA_FORMAT_DVD = "DVD";
    public static final String MEDIA_FORMAT_BLUE_RAY = "BlueRay";

    public static final Comparator<MediaItem> YEAR_COMPARATOR = new Comparator<MediaItem>() {
        public int compare(MediaItem o1, MediaItem o2) {
            if(o1.year == o2.year){
                return 0;
            } else if(o1.year < o2.year){
                return -1;
            } else {
                return 1;
            }
        }
    };

    private String type;
    private String format;

    private String title;
    private int year;
    private HashMap<String, String> metaData = new HashMap<String, String>();

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

    public void addMetaData(String dataTitle, String datValue){
        metaData.put(dataTitle, datValue);
    }

    public String getMetaData(String dataTitle){
        return metaData.get(dataTitle);
    }

    public int compareTo(MediaItem mi) {
        return this.title.compareTo(mi.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaItem mediaItem = (MediaItem) o;

        if (year != mediaItem.year) return false;
        if (type != null ? !type.equals(mediaItem.type) : mediaItem.type != null) return false;
        if (format != null ? !format.equals(mediaItem.format) : mediaItem.format != null) return false;
        if (title != null ? !title.equals(mediaItem.title) : mediaItem.title != null) return false;
        return metaData != null ? metaData.equals(mediaItem.metaData) : mediaItem.metaData == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (metaData != null ? metaData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "type='" + type + '\'' +
                ", format='" + format + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", metaData=" + metaData +
                '}';
    }
}
