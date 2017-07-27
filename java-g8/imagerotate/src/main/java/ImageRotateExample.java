import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by andrei on 7/26/17.
 */
public class ImageRotateExample {

    public static void main(String[] args) throws IOException {
        BufferedImage bufImg = ImageIO.read(new File("/Users/andrei/TEACH/samples/imagerotate/Octocat.png"));
        BufferedImage output = Scalr.rotate(bufImg, Scalr.Rotation.CW_90, null);
        ImageIO.write(output, "PNG", new File("/Users/andrei/TEACH/samples/imagerotate/Octocat_new.png"));


    }
}
