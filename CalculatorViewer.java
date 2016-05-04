import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class CalculatorViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CalculatorViewer extends JFrame
{
    // The variables that determine the width and height of the frame
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    
    // The variables that initialize a calculator viewer, a scientific calculator, a final calculator, and a gpa 
    // calculator
    private static CalculatorViewer calculator;
    private ControlPanel controls;
//     private FinalCalc finalCalc = new FinalCalc();
//     private GpaCalc gpaCalc = new GpaCalc();
    
    /**
     * Default constructor for objects of class CalculatorViewer
     */
    public CalculatorViewer()
    {
        
        this.controls = new ControlPanel();
        
        // sets the layout of the frame
        this.setLayout(new BorderLayout());
        
        // sets the size of the frame
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        // sets the frame so that it closes when the "x" button is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(controls, BorderLayout.NORTH);
        
        // sets the title of the frame
        this.setTitle("Calculators");
        
        // setting the frame so that it is visible
        this.setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
        calculator = new CalculatorViewer();
    }

}
