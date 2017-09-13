package ro.siit.java.drawingtool;

/**
 * Created by andrei on 9/11/17.
 */
public class Main {

    public static void main(String[] args) {
        DrawingTool dt = new DrawingTool();
        System.out.println(dt.addShape(new Rectangle(1, 2)));
        System.out.println(dt.addShape(new Rectangle(3, 4)));
        System.out.println(dt.addShape(new Square(4)));
        System.out.println(dt.addShape(new Shape() {
            public float computeSurface() {
                return 10;
            }

            public float computePerimter() {
                return 2.3f;
            }
        }));
        System.out.println(dt.addShape(new Shape() {
            public float computeSurface() {
                return 10;
            }

            public float computePerimter() {
                return 2.3f;
            }
        }));

        float totalSurface = dt.computeSurfaceOfShapes();
        System.out.println("total surface: "+totalSurface);
    }
}
