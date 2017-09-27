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
    private Image BgImage;
    private GameController GameController;
    private int i;


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
            i=1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        GamePanel.setImage(BgImage);
        Quit.addActionListener(e -> System.exit(0));

        Background.addActionListener(e -> {
            switch(i){
                case 0:
                    try {
                        BgImage=ImageIO.read(new File("Images\\maxresdefault.jpg"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }i++;GamePanel.setImage(BgImage);
                    break;
                case 1:
                    try {
                        BgImage=ImageIO.read(new File("Images\\overwatch_s_sombra___patterned_bg_by_5h3113y-dafogxe.png"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }i++;GamePanel.setImage(BgImage);
                    break;
                case 2:
                    try {
                        BgImage=ImageIO.read(new File("Images\\overwatch_sombra_wallpaper_1920x1080_by_dahmaroc-dalpnfx.jpg"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }i=0;GamePanel.setImage(BgImage);
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
                System.out.println(e.getX()+","+e.getY());
                GameController.DrawPiece(e.getX(),e.getY());
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
}
