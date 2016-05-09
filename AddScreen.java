import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("unchecked")
/**
 * Write a description of class Add here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddScreen extends JFrame implements ActionListener
{
    /** description of instance variable x (add comment for each instance variable) */
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    
    private JButton ok;
    
    private MusicSheet musicSheet;
    
    private JPanel panel = new JPanel();
    private JLabel titleQuestion;
    private JLabel keyQuestion;
    private JLabel tempoQuestion;
    private JLabel modeQuestion;
    
    private String pieceTitle = "No Title";
    private String tempo = "0";
    private String key = "C";
    private String mode = "None";
    private String str;
    
    private JTextField titleField = new JTextField(15);
    private JTextField tempoField = new JTextField(15);

    private String[] keys = {"C" , "G" , "D" , "A" , "E" , "B" , "F#" , "C#" , "F" , "Bb" , "Eb" , "Ab" , "Db" , "Gb" , "Cb"};
    private JComboBox keyCmbList = new JComboBox(keys);
    private String[] majMin = {"Major" , "Minor"};
    private JComboBox majMinCmb = new JComboBox(majMin);
    private int selectedRowNum=-1;
    
    private MainScreen mainScreen;
    /**
     * Default constructor for objects of class Add
     */
    public AddScreen(MainScreen mainScreen,int rownum , String str)
    {
        panel.setLayout(new FlowLayout(-2));
        
        this.str = str;
        this.mainScreen = mainScreen;
        
        this.setTitle("Add Screen");
        this.titleQuestion = new JLabel("Title of the piece:");
        this.tempoQuestion = new JLabel("Tempo: (40-216)");
        this.modeQuestion = new JLabel("Major/Minor");
        this.keyQuestion = new JLabel("Key:");
        
        this.ok = new JButton("Ok");
        this.ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (selectedRowNum < 0 )
                { 
                    musicSheet = new MusicSheet(getKey() , getPieceTitle() , getTempo() , getMode());
                    mainScreen.addMusicSheet(musicSheet);
                }
                else
                {
                    ArrayList<MusicSheet> musiclist = mainScreen.getMusicList();
                    musiclist.get(selectedRowNum).setTitle(getPieceTitle());
                    musiclist.get(selectedRowNum).setTempo(getTempo());
                    musiclist.get(selectedRowNum).setMode(getMode());
                    musiclist.get(selectedRowNum).setKey(getKey());
                }
                dispose();
            }
        });
        
        this.tempo = tempoField.getText();
        this.pieceTitle = titleField.getText();

        keyCmbList.setSelectedIndex(0);
        keyCmbList.addActionListener(this);

        majMinCmb.setSelectedIndex(0);
        majMinCmb.addActionListener(this);
        
        if (rownum > 0)
        {
            rownum--;
            selectedRowNum = rownum;
            ArrayList<MusicSheet> musiclist = this.mainScreen.getMusicList();
            if (rownum >=0 && rownum < musiclist.size())
            {
                this.titleField.setText(musiclist.get(rownum).getTitle());
                this.tempoField.setText(musiclist.get(rownum).getTempo());
                this.majMinCmb.setSelectedItem(musiclist.get(rownum).getMode());
                this.keyCmbList.setSelectedItem(musiclist.get(rownum).getKey());
            }
        }
        else if(!str.equals(" "))
        {
            ArrayList<MusicSheet> musicList = this.mainScreen.getMusicList();
            ArrayList<MusicSheet> tempList = new ArrayList<MusicSheet>();
            String keyword = str;
            ArrayList<String> substrings = new ArrayList<String>();
            for(int i = 0; i < keyword.length(); i++)
            {
                for(int j = 1; i <= keyword.length()-i; j++)
                {
                    String sub = keyword.substring(i , j+1);
                    substrings.add(sub);
                }
            }
            
            for(int i = 0; i < musicList.size(); i++)
            {
                if(musicList.get(i).equals(substrings.get(i)))
                {
                    tempList.add(musicList.get(i));
                }
            }
            
            SearchViewScreen searchViewScreen = new SearchViewScreen(tempList);
        }
        
            
        
        
        panel.setLayout(new FlowLayout(-2));
        panel.add(titleQuestion);
        panel.add(titleField);
        panel.add(tempoQuestion);
        panel.add(tempoField);
        panel.add(modeQuestion);
        panel.add(majMinCmb);
        panel.add(keyQuestion);
        panel.add(keyCmbList);
        panel.add(ok);
        
        this.add(panel);
        this.setSize(FRAME_WIDTH , FRAME_HEIGHT);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == keyCmbList)
        {
            JComboBox cb = (JComboBox)e.getSource();
            String msg = (String)cb.getSelectedItem();
            switch(msg)
            {
                case "C": key = msg;
                break;
                case "G": key = msg;
                break;
                case "D": key = msg;
                break;
                case "A": key = msg;
                break;
                case "E": key = msg;
                break;
                case "B": key = msg;
                break;
                case "F#": key = msg;
                break;
                case "C#": key = msg;
                break;
                case "F": key = msg;
                break;
                case "Bb": key = msg;
                break;
                case "Eb": key = msg;
                break;
                case "Ab": key = msg;
                break;
                case "Db": key = msg;
                break;
                case "Gb": key = msg;
                break;
                case "Cb": key = msg;
                break;
                default: key = "C";
            }
        }
        else if(e.getSource() == majMinCmb)
        {
            JComboBox cb = (JComboBox)e.getSource();
            String msg = (String)cb.getSelectedItem();
            switch(msg)
            {
                case "Major": mode = msg;
                break;
                case "Minor": mode = msg;
                break;
                default: mode = "None";
            }
        }
        
    }
    
    public String getPieceTitle()
    {
        this.pieceTitle = titleField.getText();
        return this.pieceTitle;
    }

    public String getTempo()
    {
        this.tempo = tempoField.getText();
        return this.tempo;
    }
    
    public String getKey()
    {
        return this.key;
    }
    
    public String getMode()
    {
        return this.mode;
    }
    
    public MusicSheet getMusicSheet()
    {
        return musicSheet;
    }
    
}
