import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

@SuppressWarnings("unchecked")
/**
 * Screen that is the frame which contains all the options for the music sheet database
 * 
 * @author (Tong) 
 * @version (10 May 2016)
 */
public class MainScreen extends JFrame
{
    // The variables that determine the width and height of the frame
    private static final int FRAME_WIDTH = 490;
    private static final int FRAME_HEIGHT = 200;

    // Creates an instance of itself in order to transfer information between windows
    private static MainScreen mainScreen;
    // Creates an instance of MenuSelect, or the options for the music sheet database
    private MenuSelect menu;
    // A sort of ID that is associated with a MusicSheet Object
    private int nextprimarykey;
    // The master array list where every music sheet object is stored
    private ArrayList<MusicSheet> musicList = new ArrayList<MusicSheet>();
    /**
     * Constructor for the class Viewer, which sets up the frame.
     */
    public MainScreen()
    {
        deserializeMusicSheetList();

        this.menu = new MenuSelect(this);
        this.setLayout(new BorderLayout());
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.add(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Music Sheet Sorter");
        this.setVisible(true);
    }

    /**
     * Method which is able to add a music sheet object from another window to the master array list
     *
     * @post    add a music sheet object from another window to the master array list
     *          
     * @param   musicSheet   a MusicSheet object
     */
    public void addMusicSheet(MusicSheet musicSheet)
    {
        musicList.add(musicSheet);
    }

    /**
     * Method which is able to get the master array list
     *
     * @post    get the master array list 
     *          
     */
    public ArrayList<MusicSheet> getMusicList()
    {
        return this.musicList;
    }

    /**
     * Main method of Viewer class which creates a new MainScreen object
     *
     * @post    creates a new mainscreen object
     *          
     */
    public static void main(String[] args)
    {
        mainScreen = new MainScreen();
    }

    /**
     * Method which is able to get the primary key of the music sheet object
     *
     * @post    get the primary key of the music sheet object
     *          
     */
    public int getNextPrimaryKey()
    {
        return ++nextprimarykey;
    }

    /**
     * Method which is able to serialize the music sheet list
     *
     * @post    serialize the music sheet list
     *          
     */
    public void serializeMusicSheetList()
    {
        try
        {
            FileOutputStream fout = new FileOutputStream("musicsheet.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);   
            oos.writeObject(musicList);
            oos.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Method which is able to deserialize the music sheet list
     *
     * @post    deserialize the music sheet list
     *          
     */
    public void deserializeMusicSheetList()
    {
        try
        {
            FileInputStream fin = new FileInputStream("musicsheet.ser");
            ObjectInputStream input = new ObjectInputStream (fin);
            //deserialize the List
            musicList =  (ArrayList<MusicSheet>)input.readObject();
            input.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        if (musicList.size()>0)
        {
            nextprimarykey = musicList.get(musicList.size()-1).getPrimaryKey();
        }
        else
            nextprimarykey = 0;
    }

}
