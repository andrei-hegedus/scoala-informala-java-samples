package siit6.threads.streaming.v2;

/**
 * Created by andrei on 2/17/17.
 */
public class StreamingExample {
    public static void main(String[] args) {
        VideoStream vs = new VideoStream();
        VideoStreamingClient vsc = new VideoStreamingClient(vs);
        VideoProvider vh = new VideoProvider(vs);
        vsc.startPlayback();
        vh.start();
    }
}
