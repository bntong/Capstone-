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
    private JButton add;
    private JButton update;
    private JButton delete;
    private JButton view;
    /**
     * Default constructor for objects of class MenuSelect
     */
    public MenuSelect()
    {
        // initialise instance variables
        this.add = new JButton("Add");
        this.update = new JButton("Update");
        this.delete = new JButton("Delete");
        this.view = new JButton("View");
        
        this.add.addActionListener(new Add());
        this.update.addActionListener(new Update());
        this.delete.addActionListener(new Delete());
        this.view.addActionListener(new View());
        
        
        this.add(this.add);
        this.add(this.update);
        this.add(this.delete);
        this.add(this.view);
    }
    
    public class Add implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            AddScreen addScreen = new AddScreen();
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
            DeleteScreen delScreen = new DeleteScreen();
        }
    }
    
    public class View implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ViewScreen viewScreen = new ViewScreen();
        }
    }
}
