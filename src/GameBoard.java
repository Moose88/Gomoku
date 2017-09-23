
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

    public class GameBoard {
    private JButton ResetButton;
    private JButton BackButton;
    private JButton QuitButton;
    private JPanel GameBoard;
    private GamePanel BoardPanel;
    private static int i =0;

        private GameBoard() {
            QuitButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                   System.exit(0);
                }
            });
            ResetButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }
            });
            BackButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }
            });
        }

        public static void main(String[] args) {

        JFrame frame = new JFrame("Gomoku");

        frame.setContentPane(new GameBoard().GameBoard);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("System");
        JMenuItem menuItem = new JMenuItem("Background");

        menuItem.addActionListener(new ActionListener(){
            //TODO attempt to convert to lambda function
            @Override
            public void actionPerformed(ActionEvent h) {
                BoardPanel.ChangeImage();
            }
        });

        JMenuItem menuItem2 = new JMenuItem("Quit");
        menuItem2.addActionListener(e -> System.exit(0));

        jmenu.add(menuItem);
        jmenu.add(menuItem2);

        frame.setJMenuBar(menuBar);
        menuBar.add(jmenu);
        frame.setVisible(true);

    }


}