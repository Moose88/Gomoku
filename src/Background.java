
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Background extends JComponent {

//    File testImage;
//    BufferedImage myImage;
//
//    public Background(String path) {
//        testImage = new File(path);
//        try {
//            myImage = ImageIO.read(testImage);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    Image image;
    public Background(Image image){

        this.image = image;
    }
//    @Override
//    protected void paintComponent(Graphics g)
//    {
//        super.paintComponent(g);
//        g.drawImage(myImage,0,0,this);
//    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponents(g);
        g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(),null);

    }



}
