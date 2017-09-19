
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
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("C:\\Users\\mattc\\IdeaProjects\\Gomoku\\src\\test.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //frame.setBackground(new Background("C:\\Users\\mattc\\IdeaProjects\\Gomoku\\src\\test.jpg"));
        frame.setContentPane(new Background(image));

        menuBar = new JMenuBar();
        jmenu = new JMenu("System");
        menuItem = new JMenuItem("Background");
        menuItem.addActionListener(e -> {
            //TODO Add background image variable change here
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