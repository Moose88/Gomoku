import javax.swing.*;

public class GameBoard {
    private JButton ResetButton;
    private JButton BackButton;
    private JButton QuitButton;
    private JPanel GameBoard;
    private JPanel BoardPanel;
    private static JMenu jmenu;
    private static JMenuItem menuItem;
    private static JMenuItem menuItem2;
    private static JMenuBar menuBar;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Gomuku");

        frame.setContentPane(new GameBoard().GameBoard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();


        menuBar = new JMenuBar();
        jmenu = new JMenu("System");
        menuItem = new JMenuItem("Background");
        menuItem2 = new JMenuItem("Quit");

        jmenu.add(menuItem);
        jmenu.add(menuItem2);

        frame.setJMenuBar(menuBar);
        menuBar.add(jmenu);
        frame.setVisible(true);

    }


}
