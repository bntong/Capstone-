import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Write a description of class Viewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScreen extends JFrame
{
    // The variables that determine the width and height of the frame
    private static final int FRAME_WIDTH = 490;
    private static final int FRAME_HEIGHT = 200;
    
    private static MainScreen mainScreen;
    private MenuSelect menu;
    private int nextprimarykey=0;
    
    private ArrayList<MusicSheet> musicList = new ArrayList<MusicSheet>();
    /**
     * Default constructor for objects of class Viewer
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
    
    public void addMusicSheet(MusicSheet musicSheet)
    {
        musicList.add(musicSheet);
    }
    
    public ArrayList<MusicSheet> getMusicList()
    {
        return this.musicList;
    }
    
    public static void main(String[] args)
    {
        mainScreen = new MainScreen();
    }
    
    public int getNextPrimaryKey()
    {
        return ++nextprimarykey;
    }
    
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
     }
    
}
