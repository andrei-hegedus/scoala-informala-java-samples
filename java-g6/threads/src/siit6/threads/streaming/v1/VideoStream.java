package siit6.threads.streaming.v1;

/**
 * Created by andrei on 2/17/17.
 */
// Shared Resource
public class VideoStream {

    private String frame;

    public String getFrame(){
        String f =frame;
        frame = null;
        return f;
    }

    public boolean hasFrame(){
        return frame!=null;
    }

    public void putFrame(String frame){
        this.frame = frame;
    }
}
