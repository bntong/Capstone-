import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Displays all the music sheet objects in the master Arraylist into a table
 * 
 * @author (Tong) 
 * @version (10 May 2016)
 */
public class ViewScreen extends JFrame
{
    // Width and height of frame
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    // table which contains the music sheet objects and its information
    private JTable musicTable;

    // instance of main screen so it can get information from the original main screen
    private MainScreen mainScreen;

    private String viewType; // To differentiate whether it is search or view all
    /**
     * constructor for objects of class View
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

        // if view type is "view" then all the music sheet objects are displayed
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

        // if view type is "search" then the keyword that the user inputs is then used to search through
        // the master array list to find any title that contains the keyword. It then displays the objects found.
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
        // if viewtype is "delete" then the primary key that the user inputs is used to delete the 
        // music sheet object specified
        if(viewType.equals("Delete"))
        {
            int key = -1;
            try
            {
                key = Integer.parseInt(searchKey);
            }
            catch(Exception e)
            {
                key = -1;
            }
            Iterator<MusicSheet> musicItr = musicList.iterator();
            while(musicItr.hasNext())
            {
                MusicSheet musicSheet = musicItr.next();
                if(musicSheet.getPrimaryKey() == key)
                {
                    musicItr.remove();
                }
            }
            mainScreen.serializeMusicSheetList();
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
    }

}
