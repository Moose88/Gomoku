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
    private BufferedImage ImageOne;
    private BufferedImage ImageTwo;
    private BufferedImage ImageThree;
    private GameController GameController;
    private int i;
    private int size = 500;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GameBoard frame = new GameBoard();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private GameBoard(){
        setTitle("Gomoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(525,600);
        setResizable(false);
        setContentPane(ContentPane);
        MenuBar = new JMenuBar();

        SystemMenu = new JMenu("System");
        Background= new JMenuItem("Background");
        Quit = new JMenuItem("Quit");
        SystemMenu.add(Background);
        SystemMenu.add(Quit);
        MenuBar.add(SystemMenu);
        setJMenuBar(MenuBar);
        try {
            BgImage=ImageIO.read(new File("Images\\maxresdefault.jpg"));
            ImageOne = Resize(BgImage);
            i=1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        GamePanel.setImage(ImageOne);
        Quit.addActionListener(e -> System.exit(0));

        Background.addActionListener(e -> {
            switch(i){
                case 0:
                    try {
                        BgImage=ImageIO.read(new File("Images\\maxresdefault.jpg"));
                        ImageOne = Resize(BgImage);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }i++;GamePanel.setImage(ImageOne);
                    GameController.Redraw(ImageOne);
                    break;
                case 1:
                    try {
                        BgImage=ImageIO.read(new File("Images\\overwatch_s_sombra___patterned_bg_by_5h3113y-dafogxe.png"));
                        ImageTwo = Resize(BgImage);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }i++;GamePanel.setImage(ImageTwo);
                    GameController.Redraw(ImageTwo);
                    break;
                case 2:
                    try {
                        BgImage=ImageIO.read(new File("Images\\overwatch_sombra_wallpaper_1920x1080_by_dahmaroc-dalpnfx.jpg"));
                        ImageThree = Resize(BgImage);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }i=0;GamePanel.setImage(ImageThree);
                    GameController.Redraw(ImageThree);
                    break;
                default:
                    break;
            }
        });
        ContentPane.setBackground(Color.BLACK);

        ResetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                GameController.NewGame();
            }
        });
        BackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        QuitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        GamePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()/(GamePanel.getWidth()/15);
                int y =e.getY()/(GamePanel.getHeight()/15);
                System.out.println(x +","+y);
                GameController.Move(x,y);
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
}
