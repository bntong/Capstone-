import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 * All the options that can be performed on the music sheet database, such as add, view, edit, search, etc.
 * 
 * @author (Tong) 
 * @version (10 May 2016)
 */
public class MenuSelect extends JPanel
{
    // Buttons on the frame that can be used to perform certain actions on the database
    private JButton add;
    private JButton view;
    private JButton edit;
    private JButton search;

    // Text fields that can be used to find a music sheet object or to edit one directly by entering in the primary key of the
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
        // buttons which can be used to perform certain actions on the music sheet array list
        this.add = new JButton("Add");
        this.view = new JButton("View");
        this.edit = new JButton("Edit");
        this.search = new JButton("Search");
        this.primaryKeyTextField = new JTextField(15);
        this.searchText = new JTextField(15);

        // labels to ask the user specific questions 
        this.question = new JLabel("What would you like to do?");
        this.editquestion = new JLabel("Which index would you like to edit?");
        this.searchQuestion = new JLabel("Search title by keyword:");

        // adds action listeners to all the buttons
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

    // takes the user to the add screen
    public class Add implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            AddScreen addScreen = new AddScreen(mainScreen,-1 , " ");
        }
    }

    // takes the user to the edit screen where they can edit a music object of a certain index
    public class Update implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            AddScreen addScreen = new AddScreen(mainScreen,getPrimaryKey() , getKeyword());
        }
    }

    // takes the user to a screen where everything in the master array list is displayed
    public class View implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ViewScreen viewScreen = new ViewScreen(mainScreen , "View","");

        }
    }

    // lets the user search using a specific keyword, then displays all those music objects containing the keyword
    public class Search implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ViewScreen viewScreen = new ViewScreen(mainScreen , "Search", searchText.getText());

        }
    }

    /*
     * Gets the primary key of the music sheet
     * 
     * @returns     returns the primary key of the music sheet object as an integer
     */
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

    /*
     * gets the keyword that user specifies
     * 
     * @returns     returns the keyword that the user specifies as a String
     */
    public String getKeyword()
    {        
        String str = search.getText();
        return str;
    }
}
