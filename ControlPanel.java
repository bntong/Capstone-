import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class ControlPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private JButton finalCalc;
    private JButton gpaCalc;
    private JButton sciCalc;

    /**
     * Default constructor for objects of class ControlPanel
     */
    public ControlPanel()
    {
        // assigns the three instance variables to a button which indicates which calculator the user picks
        this.finalCalc = new JButton("Final Calculator");
        this.gpaCalc = new JButton("Grade Point Average Calculator");
        this.sciCalc = new JButton("Scientific Calculator");
        
        this.add(this.finalCalc);
        this.add(this.gpaCalc);
        this.add(this.sciCalc);
    }

}
