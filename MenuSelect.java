import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
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
    private JButton view;
    private JButton edit;
    private JButton search;
    private JTextField primaryKeyTextField;
    private JTextField searchText;
    private JLabel editquestion;
    private JLabel question;
    private JLabel searchQuestion;
    
    private MainScreen mainScreen;
    /**
     * Default constructor for objects of class MenuSelect
     */
    public MenuSelect(MainScreen mainScreen)
    {
        this.setLayout(new FlowLayout(-2));
        
        this.mainScreen = mainScreen;
        // initialise instance variables
        this.add = new JButton("Add");
        this.view = new JButton("View");
        this.edit = new JButton("Edit");
        this.search = new JButton("Search");
        this.primaryKeyTextField = new JTextField(15);
        this.searchText = new JTextField(15);
        
        this.question = new JLabel("What would you like to do?");
        this.editquestion = new JLabel("Which index would you like to edit?");
        this.searchQuestion = new JLabel("Search title by keyword:");
        
        this.add.addActionListener(new Add());
        this.view.addActionListener(new View());
        this.edit.addActionListener(new Update());
        this.search.addActionListener(new Search());

        this.add(this.question);
        this.add(this.add);
        this.add(this.view);
        this.add(this.editquestion);
        this.add(this.edit);
        this.add(this.primaryKeyTextField);
        this.add(this.searchQuestion);
        this.add(this.searchText);
        this.add(this.search);

    }

    public class Add implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            AddScreen addScreen = new AddScreen(mainScreen,-1, " ");
        }
    }

    public class Update implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            AddScreen addScreen = new AddScreen(mainScreen,getPrimaryKey() , getKeyword());
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
            ViewScreen viewScreen = new ViewScreen(mainScreen , "View","");
            
        }
    }
    
    public class Search implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ViewScreen viewScreen = new ViewScreen(mainScreen , "Search", searchText.getText());
            
        }
    }
    
    public int getPrimaryKey()
    {
        try
        {    
        String str=primaryKeyTextField.getText();
        return Integer.parseInt(str);
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public String getKeyword()
    {        
            String str = search.getText();
            return str;
    }
}
