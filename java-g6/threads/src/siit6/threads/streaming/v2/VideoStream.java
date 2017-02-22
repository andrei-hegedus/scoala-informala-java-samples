package siit6.threads.streaming.v2;

/**
 * Created by andrei on 2/17/17.
 */
// Shared Resource
public class VideoStream {

    private String frame;

    public synchronized String getFrame() throws VideoStreamException {
        try {
            if (frame == null) {
                wait();
            }
            String f = frame;
            frame = null;
            notify();
            return f;
        } catch (InterruptedException e) {
            throw new VideoStreamException(e);
        }
    }


    public synchronized void putFrame(String frame) throws VideoStreamException {
        try {
            if (this.frame != null) {
                wait();
            }
            this.frame = frame;
            notify();
        } catch (InterruptedException e) {
            throw new VideoStreamException(e);
        }
    }
}
