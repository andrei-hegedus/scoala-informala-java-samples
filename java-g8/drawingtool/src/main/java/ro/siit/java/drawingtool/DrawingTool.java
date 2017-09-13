package ro.siit.java.drawingtool;

/**
 * Created by andrei on 9/11/17.
 */
public class DrawingTool {

    private int shapesCount = 0;
    private Shape [] shapes = new Shape[10];

    public boolean addShape(Shape s){
        if(containsTypeOf(s)){
            return false;
        } else {
            shapes[shapesCount++] = s;
            return true;
        }
    }

    private boolean containsTypeOf(Shape s) {
        for(Shape shape : shapes){
            if(shape != null && shape.getClass().equals(s.getClass())){
                return true;
            }
        }
        return false;
    }

    public float computeSurfaceOfShapes() {
        float totalSurface = 0;
        for(Shape s : shapes){
            if(s!=null){
                totalSurface += s.computeSurface();
            }
        }
        return totalSurface;
    }
}
