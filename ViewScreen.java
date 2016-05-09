import java.awt.*;
import javax.swing.*;
import java.util.*;

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
    
    private JTable musicTable;
    
    private JLabel question;
    
    private MainScreen mainScreen;
    /**
     * Default constructor for objects of class View
     */
    public ViewScreen(MainScreen mainScreen)
    {
        String[] columnNames = {"Index","Title" , "Key" ,"Major/Minor", "Tempo"};
        
        this.mainScreen = mainScreen;
        ArrayList<MusicSheet> musicList = mainScreen.getMusicList();
        
        this.question = new JLabel("List of the pieces in your inventory:");
        
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        
//         this.add(this.question , BorderLayout.NORTH);
        this.setTitle("Music Sheet Sorter");
        this.setVisible(true);
        
        Object[][] data = new Object[mainScreen.getMusicList().size()][5];
        
        for(int i = 0; i < musicList.size(); i++)
        {
            data[i][0] = i + 1;
             data[i][1] = musicList.get(i).getTitle();
            data[i][2] = musicList.get(i).getKey();
            data[i][3] = musicList.get(i).getMode();
            data[i][4] = musicList.get(i).getTempo();
        }
        
        JTable table = new JTable(data , columnNames);
        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table , BorderLayout.CENTER);
    }

}
