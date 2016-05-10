import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class ErrorMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ErrorMessage extends JFrame
{
    // instance variables - replace the example below with your own
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 100;
    
    private JLabel errorMessage;

    /**
     * Constructor for objects of class ErrorMessage
     */
    public ErrorMessage()
    {
        this.setLayout(new FlowLayout(-2));
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.setTitle("Error Message");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.errorMessage = new JLabel("Error: Invalid ID");
        this.add(errorMessage);
        this.setVisible(true);
    }

}
