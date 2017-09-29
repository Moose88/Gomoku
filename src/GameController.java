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
    private MoveStack MoveStack;

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
        GamePanel.repaint();
    }
    public void Redraw(BufferedImage image)
    {
        this.Image = image;
        MakeBoard();
        Repiece(MoveStack.ptr);
    }
    private boolean CheckValidMove(int x, int y)
    {
        if(MoveTracker[x][y] == null) return true;
        return false;
    }
    public void Move(int x, int y)
    {
        if (!CheckValidMove(x,y))
            return;
        if(IsBlack){
            MoveTracker[x][y] = "B";
            WinCond("B");
            MoveStack.Push(x,y,IsBlack);
            IsBlack = false;
        }
        else{
            MoveTracker[x][y] = "W";
            WinCond("W");
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
    private StackObject Repiece(StackObject tempPtr)
    {
        if(tempPtr == null)
            return tempPtr;
        Graphics2D g;
        g = Image.createGraphics();
        if(tempPtr.IsBlack) g.setColor(Color.BLUE);
        else g.setColor(Color.ORANGE);
        g.fillOval(tempPtr.x*(width/14)-10,tempPtr.y*(width/14)-10,20,20);
        GamePanel.repaint();
        return Repiece(tempPtr.next);
    }
    public void ImBackBitches(){
        this.Image=GamePanel.getImage();
        MakeBoard();
        GamePanel.repaint();
        if (MoveStack.ptr == null) return;
        MoveTracker[MoveStack.ptr.x][MoveStack.ptr.y] = null;
        if(MoveStack.ptr.IsBlack) IsBlack=true;
        else IsBlack=false;
        MoveStack.Pop();
        Repiece(MoveStack.ptr);
    }

    private void MakeBoard(){
        width = GamePanel.getWidth();
        height = GamePanel.getHeight();

        Graphics2D g;

        g = Image.createGraphics();

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(1));
        for(int i = 0; i<=BoardSize;i++)
        {
            g.drawLine(0,i*(height/14),width-10,i*(width/14));
        }
        for(int i=0;i<=BoardSize;i++)
        {
            g.drawLine(i*(width/14),0,i*(height/14),height-10);
        }

    }

    private void WinCond(String c){

        int count = 0;
        int x = 0;
        int y = 0;

        for(int i=0; i < 15; i++){

            for(int j = 0; j < 15; j++) {

                    if (x + i < 15 && y + j < 15 && MoveTracker[x + i][y + j] == c) count++; // Checks all in x direction moving down y
                    else if (x + j < 15 && y + i < 15 && MoveTracker[x + j][y + i] == c) count++; // Checks all y direction moving down x
                    else if (x + j + i < 15 && MoveTracker[x + j + i][y + j] == c) count++; // Checks all diagonally from top left to bottom right moving in y direction
                    else if (y + j + i < 15 && MoveTracker[x + j][y + j + i] == c) count++; // Checks all diagonally from top left to bottom right moving in x direction
                    else if (14 - x - j - i >= 0 && y + j < 15 && MoveTracker[14 - x - j - i][y + j] == c) count++; // Checks all diagonally from top right to bottom left moving in x direction
                    else if (14 - x - j >= 0 && y + j + i < 15 && MoveTracker[14 - x - j][y + j + i] == c) count++; // Checks all diagonally from top right to bottom left moving in y direction
                    else count = 0;

                    System.out.println("count = " + count);

                    if (count == 5) break;

            }

            if (count == 5) break;
        }

        if(count == 5) System.out.println("Winner!");

    }

}
