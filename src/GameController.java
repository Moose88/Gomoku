import java.awt.*;
import java.awt.image.BufferedImage;

public class GameController {
    private  GamePanel GamePanel;
    private BufferedImage Image;
    private int width;
    private int height;
    private boolean GameOver;
    private String MoveTracker[][];
    private int BoardSize = 14;
    private boolean IsBlack;

    GameController(GamePanel GamePanel, BufferedImage Image)
    {
        this.GamePanel = GamePanel;
        this.Image = Image;

    }
    public void NewGame(){
        this.GameOver=false;
        this.IsBlack=true;
        this.MoveTracker = new  String[BoardSize][BoardSize];
        GamePanel.setImage(Image);
        MakeBoard();
        GamePanel.repaint();
    }

    public void DrawPiece(int x, int y)
    {
        Graphics2D g;
        g = Image.createGraphics();
        if (IsBlack) {
            g.setColor(Color.BLUE);
            g.fillOval(x % 15, y % 15, 15, 15);
            IsBlack = false;

        }else{
            g.setColor(Color.ORANGE);
            g.fillOval(x % 15, y % 15, 15, 15);
            IsBlack = true;
        }
        GamePanel.repaint();

    }

    private void MakeBoard(){
        width = GamePanel.getWidth();
        height = GamePanel.getHeight();

        Graphics2D g;

        g = Image.createGraphics();

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(5));
        for(int i = 1; i<=BoardSize;i++)
        {
            g.drawLine(0,i*(height/15),width,i*(width/15));
        }
        for(int i=1;i<=BoardSize;i++)
        {
            g.drawLine(i*(width/15),0,i*(height/15),height);
        }


//        g.drawLine(0, height/15, width, width/15);
//        g.drawLine(0, 2*height/15, width, 2*width/15);
//        g.drawLine(width/15, 0, height/15, height);
//        g.drawLine(2*width/15,0,2*height/15,height);
    }

}
