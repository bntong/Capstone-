import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class Viewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScreen extends JFrame
{
    // The variables that determine the width and height of the frame
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    
    private static MainScreen mainScreen;
    private MenuSelect menu;
    
    private JLabel question;
    /**
     * Default constructor for objects of class Viewer
     */
    public MainScreen()
    {
        this.question = new JLabel("What would you like to do?");
        this.menu = new MenuSelect();
        this.setLayout(new BorderLayout());
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.add(menu , BorderLayout.SOUTH);
        this.add(this.question , BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Music Sheet Sorter");
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        mainScreen = new MainScreen();
    }
}
