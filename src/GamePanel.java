import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
private static Image BgImage;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(BgImage, 0, 0, this.getWidth(),this.getHeight(),null);

    }
    public Image getImage(){
        return BgImage;
    }
    public void setImage(Image image){
        this.BgImage = image;
        this.repaint();
    }
}
