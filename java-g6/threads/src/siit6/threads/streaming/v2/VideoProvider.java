package siit6.threads.streaming.v2;

/**
 * Created by andrei on 2/17/17.
 */
// Producer
public class VideoProvider extends Thread {

    private int frameCount = 1;
    private VideoStream stream;

    public VideoProvider(VideoStream stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        while (true) {
            //Thread.sleep(2000);
            String frame = "F" + frameCount++;
            try {
                stream.putFrame(frame);
            } catch (VideoStreamException e) {
                e.printStackTrace(System.err);
            }
            System.out.println("VH: added frame " + frame + " to stream");
        }
    }
}
