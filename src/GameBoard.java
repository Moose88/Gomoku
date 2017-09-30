import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoard extends JFrame{
    private JButton ResetButton;
    private JButton BackButton;
    private JButton QuitButton;
    private JPanel ContentPane;
    private GamePanel GamePanel;
    private JMenuBar MenuBar;
    private JMenu SystemMenu;
    private JMenuItem Background;
    private JMenuItem Quit;
    private BufferedImage BgImage;
    private BufferedImage CleanImage;
    private GameController GameController;
    private int i=0;
    private int size = 500;


    public static void main(String[] args) { // Initiates the Gameboard
        EventQueue.invokeLater(() -> {
            try {
                GameBoard frame = new GameBoard();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private GameBoard(){ // Builds the gameboard and assigns all appropriate variables to needed values
        setTitle("Gomoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setUndecorated(true);
        setSize(525,600);
        setResizable(false);
        setContentPane(ContentPane);
        MenuBar = new JMenuBar();

        SystemMenu = new JMenu("System"); // For the Menu Bar and it's functions
        Background= new JMenuItem("Background");
        Quit = new JMenuItem("Quit");
        SystemMenu.add(Background);
        SystemMenu.add(Quit);
        MenuBar.add(SystemMenu);
        setJMenuBar(MenuBar);
        BgImage = chooseBackground();
        i++;
        GamePanel.setImage(BgImage);

        Quit.addActionListener(e -> System.exit(0)); // Allows the program to quit

        Background.addActionListener(e -> {

            BgImage = chooseBackground();
            GamePanel.setImage(BgImage);
            GameController.Redraw(BgImage);
            ++i;
            if(i>2)i=0;
        });
        ContentPane.setBackground(Color.BLACK);

        ResetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // Resets the board
                super.mouseClicked(e);
                GamePanel.setImage(CleanImage());
                GameController.NewGame();
            }
        });
        BackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // Resets the background image and goes back a play
                super.mouseClicked(e);
                GamePanel.setImage(CleanImage());
                GameController.BackStep();
            }
        });
        QuitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // Exits the game
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        GamePanel.addMouseListener(new MouseListener() { // When the panel is clicked, it will send the x and y values to be evaluated for rounding purposes
            @Override
            public void mouseClicked(MouseEvent e) {
                double X = e.getX()/(double)(GamePanel.getWidth()/14);
                double Y = e.getY()/(double)(GamePanel.getHeight()/14);

                int x = Round(X);
                int y = Round(Y);

                //System.out.println(x +","+y);
                GameController.Move(x, y);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        GamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                BufferedImage image = new BufferedImage(GamePanel.getWidth(),GamePanel.getHeight(),BufferedImage.TYPE_INT_ARGB);
                GameController = new GameController(GamePanel,image);
                GameController.NewGame();
            }
        });
    }
    BufferedImage Resize(BufferedImage Image){
        int type = Image.getType() == 0? BufferedImage.TYPE_INT_ARGB : Image.getType();
        BufferedImage Resized = new BufferedImage(size,size ,type);
        Graphics2D g = Resized.createGraphics();
        g.drawImage(Image,0,0,size,size,null);
        g.dispose();
        return Resized;
    }

    int Round(double num) { // Evaluates the clicked area to evaluate the click if before or after .5

        long iPart = (long) num;
        double fract = num - iPart;

        if (fract > .5){
            num = num + 1;
            return (int) num;

        }else{
            return (int) num;
        }
    }

    private BufferedImage chooseBackground(){ // Background image selection
        BufferedImage image =null;
        switch(i){
            case 0:
                try {
                    image=ImageIO.read(new File("Images\\maxresdefault.jpg"));
                    image = Resize(image);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case 1:
                try {
                    image=ImageIO.read(new File("Images\\overwatch_s_sombra___patterned_bg_by_5h3113y-dafogxe.png"));
                    image = Resize(image);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case 2:
                try {
                    image=ImageIO.read(new File("Images\\overwatch_sombra_wallpaper_1920x1080_by_dahmaroc-dalpnfx.jpg"));
                    image = Resize(image);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            default:
                break;
        }
        return image;
    }

    private BufferedImage CleanImage(){ // Sends the images to be resized
        BufferedImage image =null;
        switch(i){
            case 0:
                try {
                    image=ImageIO.read(new File("Images\\overwatch_sombra_wallpaper_1920x1080_by_dahmaroc-dalpnfx.jpg"));
                    image = Resize(image);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case 1:
                try {
                    image=ImageIO.read(new File("Images\\maxresdefault.jpg"));
                    image = Resize(image);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case 2:
                try {
                    image=ImageIO.read(new File("Images\\overwatch_s_sombra___patterned_bg_by_5h3113y-dafogxe.png"));
                    image = Resize(image);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            default:
                break;
        }
        return image;
    }


}
