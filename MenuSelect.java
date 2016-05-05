import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class MenuSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuSelect extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private JButton insert;
    private JButton update;
    private JButton delete;
    private JButton view;
    /**
     * Default constructor for objects of class MenuSelect
     */
    public MenuSelect()
    {
        // initialise instance variables
        this.insert = new JButton("Insert");
        this.update = new JButton("Update");
        this.delete = new JButton("Delete");
        this.view = new JButton("View");
        
        this.insert.addActionListener(new Insert());
        this.update.addActionListener(new Update());
        this.delete.addActionListener(new Delete());
        
        
        
        this.add(this.insert);
        this.add(this.update);
        this.add(this.delete);
        this.add(this.view);
    }
    
    public class Insert implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
        }
    }
    
    public class Update implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
        }
    }
    
    public class Delete implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
        }
    }
    
    public class View implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
        }
    }
}
