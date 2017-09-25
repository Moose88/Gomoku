import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
private static BufferedImage BgImage;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(BgImage, 0, 0, null);

    }
    public BufferedImage getImage(){
        return BgImage;
    }
    public void setImage(BufferedImage image){
        this.BgImage = image;
        this.repaint();
    }




}
