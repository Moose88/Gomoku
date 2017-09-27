import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameController {
    private  GamePanel GamePanel;
    private BufferedImage Image;
    private int width;
    private int height;
    private boolean GameOver;
    private String MoveTracker[][];
    private int BoardSize = 14;
    private boolean IsBlack;
    private int size = 500;
    private int Moves[][];
    private int ptr;
    GameController(GamePanel GamePanel, BufferedImage Image)
    {
        this.GamePanel = GamePanel;
        this.Image = Image;

    }

    public void NewGame(){
        this.GameOver=false;
        this.IsBlack=true;
        this.MoveTracker = new  String[15][15];
        Image = GamePanel.getImage();
        MakeBoard();
        Moves = new int[255][2];
        ptr=0;
        GamePanel.repaint();
    }
    public void Redraw(BufferedImage image)
    {
        this.Image = image;
        MakeBoard();
        // Draw pieces for each that should be
        GamePanel.repaint();
    }
    public void Move(int x, int y)
    {
        if (!CheckValidMove(x,y))
            return;
        if(IsBlack){
            MoveTracker[x][y] = "B";
            Moves[ptr][ptr]=Moves[x][y];
            ptr++;
        }
        else{
            MoveTracker[x][y] = "W";
            Moves[ptr][ptr]=Moves[x][y];
            ptr++;
        }

        //add pieces based on array
        DrawPiece((x*(width/14)-10),(y*(height/14)-10));

    }
    private boolean CheckValidMove(int x, int y)
    {
        if(MoveTracker[x][y] == null)
            return true;
        return false;
    }

    private void DrawPiece(int x, int y)
    {
        Graphics2D g;
        g = Image.createGraphics();
        if (IsBlack) {
            g.setColor(Color.BLUE);
            g.fillOval(x , y , 20, 20);
            IsBlack = false;

        }else{
            g.setColor(Color.ORANGE);
            g.fillOval(x , y , 20, 20);
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
        for(int i = 0; i<=BoardSize;i++)
        {
            g.drawLine(0,i*(height/14),width-10,i*(width/14));
        }
        for(int i=0;i<=BoardSize;i++)
        {
            g.drawLine(i*(width/14),5,i*(height/14),height-10);
        }


//        g.drawLine(0, height/15, width, width/15);
//        g.drawLine(0, 2*height/15, width, 2*width/15);
//        g.drawLine(width/15, 0, height/15, height);
//        g.drawLine(2*width/15,0,2*height/15,height);
    }

}
