package siit6.threads.streaming.v1;

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
            synchronized (stream) {
                if(stream.hasFrame()) {
                    consumeFrame();
                } else {
                    try {
                        System.out.println("VSC: no content. Waiting...");
                        stream.wait();
                        System.out.println("VSC: notified");
                        consumeFrame();
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                }
            }
        }
    }

    private void consumeFrame() {
        System.out.println("VSC: obtained frame " + stream.getFrame());
        stream.notify();
    }

    public void startPlayback(){
        canPlayStream = true;
        start();
    }

    public void stopPlayback(){
        canPlayStream = false;
    }
}
