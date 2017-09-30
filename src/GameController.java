import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
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

    // When a new game is started, will initiate all the values for the game controller

    public void NewGame(){
        this.GameOver=false;
        this.IsBlack=true;
        this.MoveTracker = new  String[15][15];
        Image = GamePanel.getImage();
        MakeBoard();
        MoveStack = new MoveStack();
        GamePanel.repaint();
    }
    public void Redraw(BufferedImage image) // Redraws the background and any appropriate pieces.
    {
        this.Image = image;
        MakeBoard();
        Repiece(MoveStack.ptr);
    }
    private boolean CheckValidMove(int x, int y) // Evaluates the clicked area to ensure the selected move is valid
    {
        if(GameOver == false && MoveTracker[x][y] == null) return true;
        return false;
    }

    public void Move(int x, int y) // If move is valid, will add to the move stack the information of the move, and evaluate if a winner is found
    {
        if (!CheckValidMove(x,y))
            return;
        if(IsBlack){
            MoveTracker[x][y] = "B";
            MoveStack.Push(x,y,IsBlack);
            IsBlack = false;
            DrawPiece();
            if(WinCheck(x, y)){
                GameOver=true;
                System.out.println("Winner!");
                JOptionPane.showMessageDialog(GamePanel, "Blue is the winner!");
            }
        }
        else{
            MoveTracker[x][y] = "W";
            MoveStack.Push(x,y,IsBlack);
            IsBlack = true;
            DrawPiece();
            if(WinCheck(x, y)){
                GameOver=true;
                System.out.println("Winner!");
                JOptionPane.showMessageDialog(GamePanel, "Magenta is the winner!");
            }
        }
    }
    private void DrawPiece(){ // The piece image information
        Graphics2D g;
        g = Image.createGraphics();
        GradientPaint PieceColor;
        if(MoveStack.ptr.IsBlack){
            PieceColor = new GradientPaint(MoveStack.ptr.x*(width/14),MoveStack.ptr.y*(width/14),Color.BLUE,(MoveStack.ptr.x*(width/14))+20,MoveStack.ptr.y*(width/14),Color.WHITE);
            g.setPaint(PieceColor);
        }
        else{
            PieceColor = new GradientPaint(MoveStack.ptr.x*(width/14),MoveStack.ptr.y*(width/14),Color.MAGENTA,(MoveStack.ptr.x*(width/14))+15,MoveStack.ptr.y*(width/14),Color.WHITE);
            g.setPaint(PieceColor);
        }
        g.fill(new Ellipse2D.Double(MoveStack.ptr.x*(width/14)-5,MoveStack.ptr.y*(width/14)-5,20,20));
        GamePanel.repaint();
    }
    private StackObject Repiece(StackObject tempPtr) // If a move is gone back, this will allow the stack to pop, then will redraw the board with the appropriate moves
    {
        if(tempPtr == null)
            return tempPtr;
        Graphics2D g;
        g = Image.createGraphics();
        GradientPaint PieceColor;
        if(tempPtr.IsBlack){
            PieceColor = new GradientPaint(tempPtr.x*(width/14),tempPtr.y*(width/14),Color.BLUE,(tempPtr.x*(width/14))+20,tempPtr.y*((width/14)),Color.WHITE);
            g.setPaint(PieceColor);
        }
        else{
            PieceColor = new GradientPaint(tempPtr.x*(width/14),tempPtr.y*(width/14),Color.MAGENTA,(tempPtr.x*(width/14))+15,tempPtr.y*(width/14),Color.WHITE);
            g.setPaint(PieceColor);
        }
        g.fill(new Ellipse2D.Double(tempPtr.x*(width/14)-5,tempPtr.y*(width/14)-5,20,20));
        GamePanel.repaint();
        return Repiece(tempPtr.next);
    }
    public void BackStep(){ // Takes a move back
        GameOver = false;
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

    private void MakeBoard(){ // Draws the board with the appropriate background, board lines, and pieces
        width = GamePanel.getWidth();
        height = GamePanel.getHeight();

        Graphics2D g;

        g = Image.createGraphics();

        g.setColor(Color.GREEN);
        g.setStroke(new BasicStroke(1));
        for(int i = 0; i<=BoardSize;i++) // The x direction lines are drawn with a slight offset
        {
            g.drawLine(5,i*(height/14)+5,width-5,i*(width/14)+5);
        }
        for(int i=0;i<=BoardSize;i++) // The y direction lines are drawn with a slight offset
        {
            g.drawLine(i*(width/14)+5,5,i*(height/14)+5,height-5);
        }

    }

    private Boolean WinCheck(int x, int y){ // Evaluates if there is a winner

        String consec1[] = new String[9];

        for( int i = 0; i < 9; i++ ){ // x direction string

            if( x-4+i < 0 || x-4+i > 14 ) consec1[i] = null;
            else consec1[i] = MoveTracker[(x-4)+i][y];


        }
        //System.out.println("x = " + Arrays.toString(consec1));
        if(Consecutive(consec1)) return true;

        String consec2[] = new String[9];

        for ( int i = 0; i < 9; i++ ){ // y direction string

            if( y-4+i < 0 || y-4+i > 14 ) consec2[i] = null;
            else consec2[i] =MoveTracker[x][y-4+i];

        }
       // System.out.println("y = " + Arrays.toString(consec2));
        if( Consecutive(consec2)) return true;

        String consec3[] = new String[9];

        for( int i = 0; i < 9; i++ ){ // forward diagonal string

            if( x-4+i < 0 || x-4+i > 14 || y-4+i < 0 || y-4+i > 14) consec3[i] = null;
            else consec3[i] = MoveTracker[x-4+i][y-4+i];

        }
        //System.out.println("FD = " + Arrays.toString(consec3));
        if( Consecutive(consec3)) return true;

        String consec4[] = new String[9];

        for( int i = 0; i < 9; i++ ){ // backward diagonal string

            if( x+4-i > 14 || x+4-i < 0 || y-4+i < 0 || y-4+i > 14) consec4[i] = null;
            else consec4[i] = MoveTracker[x+4-i][y-4+i];

        }
        //System.out.println("BD = " + Arrays.toString(consec4));
        if( Consecutive(consec4)) return true;


        return false;

    }

    private Boolean Consecutive(String[] c){ // Checks to see if string has consecutive values

        int count = 0;

        for( int i = 0; i < 8; i++ ){

            if(c[i] != null && c[i] == c[i+1]) count++;
                else count = 0;

            if( count == 4 ) return true;
        }

        return false;

    }


}
