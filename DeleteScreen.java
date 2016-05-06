import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class Delete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeleteScreen extends JFrame
{
    /** description of instance variable x (add comment for each instance variable) */
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    
    private JLabel question;
    /**
     * Default constructor for objects of class Delete
     */
    public DeleteScreen()
    {
        this.question = new JLabel("What would you like to do?");
        this.setLayout(new BorderLayout());
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.add(this.question , BorderLayout.NORTH);
        this.setTitle("Music Sheet Sorter");
        this.setVisible(true);
    }

    

}
