package ro.siit.java.drawingtool;

/**
 * Created by andrei on 9/11/17.
 */
public class Rectangle implements Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public float computeSurface() {
        return width * height;
    }

    public float computePerimter() {
        return 2 * width + 2 * height;
    }
}
