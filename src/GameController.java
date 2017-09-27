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
    private MoveStack MoveStack;
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
        MoveStack = new MoveStack();
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
    private boolean CheckValidMove(int x, int y)
    {
        if(MoveTracker[x][y] == null)
            return true;
        return false;
    }
    public void Move(int x, int y)
    {

        if (!CheckValidMove(x,y))
            return;
        if(IsBlack){
            MoveTracker[x][y] = "B";
            MoveStack.Push(x,y,IsBlack);
            IsBlack = false;
        }
        else{
            MoveTracker[x][y] = "W";
            MoveStack.Push(x,y,IsBlack);
            IsBlack = true;
        }
        DrawPiece();


    }
    private void DrawPiece(){
        Graphics2D g;
        g = Image.createGraphics();
        if(MoveStack.ptr.IsBlack) g.setColor(Color.BLUE);
        else g.setColor(Color.ORANGE);
        g.fillOval(MoveStack.ptr.x*(width/14)-10,MoveStack.ptr.y*(width/14)-10,20,20);
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

    }

}
