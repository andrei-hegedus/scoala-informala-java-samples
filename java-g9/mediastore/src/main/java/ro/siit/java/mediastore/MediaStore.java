package ro.siit.java.mediastore;

/**
 * Created by andreihegedus-sirbu on 04/12/2017.
 */
public class MediaStore {

    public static final int EXPANSION_FACTOR = 2;
    public static final int ORIGINAL_SIZE = 3;

    private MediaItem[] media = new MediaItem[ORIGINAL_SIZE];
    private int mediaNextIndex = 0;

    // TODO - add media items to inventory
    public void add(MediaItem mi) {
        if (mediaNextIndex == media.length) {
            expandMediaArray();
        }
        media[mediaNextIndex] = mi;
        mediaNextIndex++;
    }

    private void expandMediaArray() {
        MediaItem[] temp = new MediaItem[media.length + EXPANSION_FACTOR];
        for(int i = 0; i < media.length; i++){
            temp[i] = media[i];
        }
        media = temp;
    }

    // TODO - remove media items from inventory
    public void remove(MediaItem mi){
        for(int i = 0; i< media.length - 1;i++){
            if(media[i].equals(mi)){
                removeAt(i);
            }
        }
    }

    private void removeAt(int i) {
        for(int j = i; j < media.length;j++){
            media[j] = media[j+1];
        }
        mediaNextIndex--;
        if(media.length > ORIGINAL_SIZE && media.length - mediaNextIndex == EXPANSION_FACTOR){
            compactArray();
        }
    }

    private void compactArray() {
        MediaItem[] temp = new MediaItem[media.length - EXPANSION_FACTOR];
        for(int i = 0; i < temp.length; i++){
            temp[i] = media[i];
        }
        media = temp;
    }
    // TODO - get all media items
    // TODO - get all media by type
    // TODO - get all music artists
}
