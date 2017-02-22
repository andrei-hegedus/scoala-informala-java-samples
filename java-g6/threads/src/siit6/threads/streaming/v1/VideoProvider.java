package siit6.threads.streaming.v1;

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
        try {
            while (true) {
                //Thread.sleep(2000);
                synchronized (stream) { // this thread has obtained access rights on stream
                    if (stream.hasFrame()) {
                        stream.wait(); // releases access rights until notified
                        // access rights granted back to this thread - via notify()
                    }
                    String frame = "F" + frameCount++;
                    stream.putFrame(frame);
                    System.out.println("VH: added frame " + frame + " to stream");
                    stream.notify();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
