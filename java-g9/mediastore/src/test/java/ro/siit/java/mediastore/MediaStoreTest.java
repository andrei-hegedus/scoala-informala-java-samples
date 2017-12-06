package ro.siit.java.mediastore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * Created by andreihegedus-sirbu on 04/12/2017.
 */
public class MediaStoreTest {

    @Test
    public void add3MediaItems(){
        MediaStore ms = new MediaStore();
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book",
                2007));
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book2",
                2007));
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book3",
                2007));
    }

    @Test
    public void add3MediaItems_andRemove1(){
        MediaStore ms = new MediaStore();
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book",
                2007));
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book2",
                2007));
        MediaItem mi = new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book3",
                2007);
        ms.add(mi);
        ms.remove(mi);
    }

    @Test
    public void addMoreThan3MediaItems(){
        MediaStore ms = new MediaStore();
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book",
                2007));
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book2",
                2007));
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book3",
                2007));
        ms.add(new MediaItem(
                MediaItem.MEDIA_TYPE_AUDIO_BOOK,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book4",
                2007));
    }

    @Test
    public void whenMusicArtistListRequested_UniqueItemsReturned(){
        MediaStore ms = new MediaStore();
        MediaItem mi1 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book",
                2007);
        ms.add(mi1);
        mi1.addMetaData("ARTIST", "Beyonce");
        MediaItem mi2 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Some book2",
                2007);
        mi2.addMetaData("ARTIST", "Beyonce");
        ms.add(mi2);
        assertEquals(1, ms.getMusicArtists().size());
    }

    @Test
    public void sortMediaItemsByTitle(){
        MediaItem mi1 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Jungle Book",
                2007);
        MediaItem mi2 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Belfast City Guide",
                2007);
        ArrayList<MediaItem> items = new ArrayList<MediaItem>();
        items.add(mi1);
        items.add(mi2);
        System.out.println(items);
        Collections.sort(items);
        ArrayList<MediaItem> expeectedOrder = new ArrayList<MediaItem>();
        expeectedOrder.add(mi2);
        expeectedOrder.add(mi1);
        assertEquals(expeectedOrder, items);
        System.out.println(items);
    }

    @Test
    public void sortMediaItemsByYear(){
        MediaItem mi1 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Jungle Book",
                2007);
        MediaItem mi2 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Belfast City Guide",
                2003);
        MediaItem mi3 = new MediaItem(
                MediaItem.MEDIA_TYPE_MUSIC,
                MediaItem.MEDIA_FORMAT_CD,
                "Belfast City Guide",
                2005);
        ArrayList<MediaItem> items = new ArrayList<MediaItem>();
        items.add(mi1);
        items.add(mi2);
        items.add(mi3);
        System.out.println(items);
        Collections.sort(items, MediaItem.YEAR_COMPARATOR);
        ArrayList<MediaItem> expeectedOrder = new ArrayList<MediaItem>();
        expeectedOrder.add(mi2);
        expeectedOrder.add(mi3);
        expeectedOrder.add(mi1);
        assertEquals(expeectedOrder, items);
        System.out.println(items);
    }

    @Test
    public void sortBasedOnMetaData(){
        ArrayList<MediaItem> items = new ArrayList<MediaItem>();
        Collections.sort(items, new Comparator<MediaItem>() {
            public int compare(MediaItem o1, MediaItem o2) {
                String artist1 = o1.getMetaData("ARTIST");
                String artist2 = o2.getMetaData("ARTIST");
                return artist1.compareTo(artist2);
            }
        });
    }
}
