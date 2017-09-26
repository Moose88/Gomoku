import java.awt.*;
import java.awt.image.BufferedImage;

public class GameController {
    private  GamePanel GamePanel;
    private BufferedImage Image;
    private int width;
    private int height;
    private boolean GameOver;
    private String MoveTracker[][];
    private int BoardSize = 13;

    GameController(GamePanel GamePanel, BufferedImage Image)
    {
        this.GamePanel = GamePanel;
        this.Image = Image;
    }
    public void NewGame(){
        this.GameOver=false;
        this.MoveTracker = new  String[BoardSize][BoardSize];
        MakeBoard();
        GamePanel.repaint();
    }

    private void MakeBoard(){
        width = GamePanel.getWidth();
        height = GamePanel.getHeight();

        Graphics2D g;

        g = Image.createGraphics();
        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(5));
        g.drawLine(0, height/15, width, width/15);
        g.drawLine(0, 2*height/15, width, 2*width/15);
        g.drawLine(width/15, 0, height/15, height);
        g.drawLine(2*width/15,0,2*height/15,height);
    }

}
