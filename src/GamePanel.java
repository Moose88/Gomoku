import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class GamePanel extends JPanel {
private static BufferedImage BgImage;

    @Override
    protected void paintComponent(Graphics g){
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
