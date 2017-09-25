import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        setSize(500,500);
        setContentPane(ContentPane);

        MenuBar = new JMenuBar();

        SystemMenu = new JMenu("System");
        Background= new JMenuItem("Background");
        Quit = new JMenuItem("Quit");
        SystemMenu.add(Background);
        SystemMenu.add(Quit);
        MenuBar.add(SystemMenu);
        setJMenuBar(MenuBar);

        Quit.addActionListener(e -> System.exit(0));
        Background.addActionListener(e -> System.out.println("add code to do the bg stuff here"));

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
        QuitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }
}
