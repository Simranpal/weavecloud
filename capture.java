import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class capture {
    
    public static void main(String[] args) {
        
        try {
            Thread.sleep(3000);
            
            Robot robot = new Robot();
            // Capture the screen shot of the area of the screen defined by the rectangle
            BufferedImage bi=robot.createScreenCapture(new Rectangle(1280, 1024));
            ImageIO.write(bi, "jpg", new File("./imageTest.jpg"));
            
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
