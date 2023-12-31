import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
private static BufferedImage BgImage;

    @Override
    protected void paintComponent(Graphics g){ // Takes the buffered images from our image files and returns them as painted components
        super.paintComponent(g);
        g.drawImage(BgImage, 0, 0, this.getWidth(),this.getHeight(),null);

    }
    public BufferedImage getImage(){
        return BgImage;
    }

    public void setImage(BufferedImage image){
        this.BgImage = image;
        this.repaint();

    }
}
