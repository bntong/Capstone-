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

    private String viewType; // To differentiate whether it is search or view all
    /**
     * Default constructor for objects of class View
     */
    public ViewScreen(MainScreen mainScreen , String viewType,String searchKey)
    {
        String[] columnNames = {"ID","Title" , "Key" ,"Major/Minor", "Tempo"};

        this.viewType = viewType;
        this.mainScreen = mainScreen;
        ArrayList<MusicSheet> musicList = mainScreen.getMusicList();

        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.setTitle("Music Sheet Sorter");
        this.setVisible(true);

        Object[][] viewData,searchData;
        if(viewType.equals("View"))
        {
            viewData  = new Object[mainScreen.getMusicList().size()][5];
            for(int i = 0; i < musicList.size(); i++)
            {
                viewData[i][0] = musicList.get(i).getPrimaryKey();
                viewData[i][1] = musicList.get(i).getTitle();
                viewData[i][2] = musicList.get(i).getKey();
                viewData[i][3] = musicList.get(i).getMode();
                viewData[i][4] = musicList.get(i).getTempo();
            }
            JTable table = new JTable(viewData , columnNames);
            this.add(table.getTableHeader(), BorderLayout.NORTH);
            this.add(table , BorderLayout.CENTER);
        }
        
        if (viewType.equals("Search"))
        {
            Object[][] tempData = new Object[mainScreen.getMusicList().size()][5];
            if(!searchKey.equals(""))
            {
                String str = searchKey.trim();
                str = str.toLowerCase();
                
                int j = 0;
                for (int i = 0; i < musicList.size(); i++)
                {
                    String tempTitle = musicList.get(i).getTitle().toLowerCase();
                    if (tempTitle.contains(str))
                    {
                        tempData[j][0] = musicList.get(i).getPrimaryKey();
                        tempData[j][1] = musicList.get(i).getTitle();
                        tempData[j][2] = musicList.get(i).getKey();
                        tempData[j][3] = musicList.get(i).getMode();
                        tempData[j][4] = musicList.get(i).getTempo();
                        j++;
                    }
                }
                
                searchData = new Object[j][5];
                for (int i=0; i < j; i++)
                {
                    searchData[i][0] = tempData[i][0];
                    searchData[i][1] = tempData[i][1];
                    searchData[i][2] = tempData[i][2];
                    searchData[i][3] = tempData[i][3];
                    searchData[i][4] = tempData[i][4];
                }
                JTable table = new JTable(searchData , columnNames);
                this.add(table.getTableHeader(), BorderLayout.NORTH);
                this.add(table , BorderLayout.CENTER);
            }
            
        }
        
    }

}
