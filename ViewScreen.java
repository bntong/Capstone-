import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ViewScreen extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    
    private JLabel question;
    /**
     * Default constructor for objects of class View
     */
    public ViewScreen()
    {
        this.question = new JLabel("What would you like to do?");
        this.setLayout(new BorderLayout());
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.add(this.question , BorderLayout.NORTH);
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Music Sheet Sorter");
        this.setVisible(true);
    }

}
