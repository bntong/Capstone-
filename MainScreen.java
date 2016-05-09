import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Write a description of class Viewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScreen extends JFrame
{
    // The variables that determine the width and height of the frame
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    
    private static MainScreen mainScreen;
    private MenuSelect menu;
    
    private ArrayList<MusicSheet> musicList = new ArrayList<MusicSheet>();
    /**
     * Default constructor for objects of class Viewer
     */
    public MainScreen()
    {
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
}
