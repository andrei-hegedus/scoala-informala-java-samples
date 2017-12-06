package ro.siit.java.mediastore;

import org.junit.Test;

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
}
