
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

    public class GameBoard {
    private JButton ResetButton;
    private JButton BackButton;
    private JButton QuitButton;
    private JPanel GameBoard;
    //private Background GameBoard;
    private JPanel BoardPanel;
    private static JMenu jmenu;
    private static JMenuItem menuItem;
    private static JMenuItem menuItem2;
    private static JMenuBar menuBar;
    private static int i =0;
        private static BufferedImage image = null;

        public GameBoard() {
            QuitButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                   System.exit(0);
                }
            });
        }

        public static void main(String[] args) {

        JFrame frame = new JFrame("Gomuku");

        frame.setContentPane(new GameBoard().GameBoard);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        menuBar = new JMenuBar();
        jmenu = new JMenu("System");
        menuItem = new JMenuItem("Background");
        menuItem.addActionListener(new ActionListener() {
            //TODO Figure out why it needs to be resized to refresh image
            //TODO attempt to conver to lambda function
            @Override
            public void actionPerformed(ActionEvent h) {
                switch (i){
                    case 0:
                try {
                    image = ImageIO.read(new File("C:\\Users\\mattc\\IdeaProjects\\Gomoku\\src\\test.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                } System.out.println("attempting to change background to background 0");
                frame.setContentPane(new Background(image));
                frame.repaint();
                i++;break;
                    case 1:
                    try {
                        image = ImageIO.read(new File("C:\\Users\\mattc\\IdeaProjects\\Gomoku\\src\\sombra_overwatch_wallpaper_by_leviathancj-dannxlh.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        System.out.println("attempting to change background to background 1");
                    frame.setContentPane(new Background(image));
                    frame.repaint();
                    i++;break;
                    case 2:
                        try {
                            image = ImageIO.read(new File("C:\\Users\\mattc\\IdeaProjects\\Gomoku\\src\\maxresdefault.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("attempting to change background to background 2");
                        frame.setContentPane(new Background(image));
                        frame.repaint();
                        i=0;break;
                    default:
            }
            }
        });

        menuItem2 = new JMenuItem("Quit");
        menuItem2.addActionListener(e -> System.exit(0));

        jmenu.add(menuItem);
        jmenu.add(menuItem2);

        frame.setJMenuBar(menuBar);
        menuBar.add(jmenu);
        frame.setVisible(true);

    }


}