import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
private static int i = 0;
private static Image BgImage;


    public void ChangeImage(){
        switch (i){
            case 0:
                try {
                    BgImage = ImageIO.read(new File("C:\\Users\\Matt\\IdeaProjects\\Gomoku\\Images\\maxresdefault.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                } System.out.println("attempting to change background to background 0");
                i++;break;
            case 1:
                try {
                    BgImage= ImageIO.read(new File("C:\\Users\\Matt\\IdeaProjects\\Gomoku\\Images\\overwatch_s_sombra___patterned_bg_by_5h3113y-dafogxe.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("attempting to change background to background 1");
                i++;break;
            case 2:
                try {
                    BgImage = ImageIO.read(new File("C:\\Users\\Matt\\IdeaProjects\\Gomoku\\Images\\overwatch_sombra_wallpaper_1920x1080_by_dahmaroc-dalpnfx.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("attempting to change background to background 2");
                i=0;break;
            default:
                repaint();
        }
        repaint();

    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(BgImage, 0, 0, this);

    }

}
