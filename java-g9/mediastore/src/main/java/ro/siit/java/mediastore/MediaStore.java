package ro.siit.java.mediastore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by andreihegedus-sirbu on 04/12/2017.
 */
public class MediaStore {

    private ArrayList<MediaItem> media = new ArrayList<MediaItem>();

    // TODO - add media items to inventory
    public void add(MediaItem mi) {
        if (!media.contains(mi)) {
            media.add(mi);
        }
    }

    // TODO - remove media items from inventory
    public void remove(MediaItem mi){
       media.remove(mi);
    }

    // TODO - get all media items
    // TODO - get all media by type
    public Set<String> getMusicArtists(){
        HashSet<String> artists = new HashSet<String>();
        for(MediaItem mi : media){
            if(mi.getType().equals(MediaItem.MEDIA_TYPE_MUSIC)){
                artists.add(mi.getMetaData("ARTIST"));
            }
        }
        return artists;
    }
}
