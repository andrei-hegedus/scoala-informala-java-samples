package siit6.threads.streaming.v2;

/**
 * Created by andrei on 2/17/17.
 */
// Consumer
public class VideoStreamingClient extends Thread {

    private VideoStream stream;
    private volatile boolean canPlayStream = false;

    public VideoStreamingClient(VideoStream stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        while(canPlayStream){
            try {
                System.out.println("VSC: obtained frame " + stream.getFrame());
            } catch (VideoStreamException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void startPlayback(){
        canPlayStream = true;
        start();
    }

    public void stopPlayback(){
        canPlayStream = false;
    }
}
