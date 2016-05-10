import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("unchecked")
/**
 * The screen where the user can make a music sheet object and add it to the master array list
 * 
 * @author (Tong) 
 * @version (10 May 2016)
 */
public class AddScreen extends JFrame implements ActionListener
{
    // Width and height of the frame
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    
    // Button which the user can press if he/she is done with the information of the music sheet object
    private JButton ok;
    
    // Instance of music sheet object
    private MusicSheet musicSheet;
    
    // variables which asks the user about the information they wish to enter
    private JPanel panel = new JPanel();
    private JLabel titleQuestion;
    private JLabel keyQuestion;
    private JLabel tempoQuestion;
    private JLabel modeQuestion;
    
    // Default variables of the music sheet object if the user does not enter in anything in the add screen
    private String pieceTitle = "No Title";
    private String tempo = "0";
    private String key = "C";
    private String mode = "None";
    private String str;
    
    // text fields of the title and the tempo of the Music Sheet object
    private JTextField titleField = new JTextField(15);
    private JTextField tempoField = new JTextField(15);
    
    // Combo boxes of of the major or minor selection and the key selection
    private String[] keys = {"C" , "G" , "D" , "A" , "E" , "B" , "F#" , "C#" , "F" , "Bb" , "Eb" , "Ab" , "Db" , "Gb" , "Cb"};
    private JComboBox keyCmbList = new JComboBox(keys);
    private String[] majMin = {"None", "Major" , "Minor"};
    private JComboBox majMinCmb = new JComboBox(majMin);
    private int primaryKeyToEdit = -1;
    
    // instance of the Main screen so the information from the mainscreen can be passed into the add screen
    private MainScreen mainScreen;
    /**
     * constructor for objects of class Add
     */
    public AddScreen(MainScreen mainScreen,int primaryKeyToEdit , String str)
    {
        panel.setLayout(new FlowLayout(-2));

        this.primaryKeyToEdit = primaryKeyToEdit;
        this.str = str;
        this.mainScreen = mainScreen;

        this.setTitle("Add Screen");
        this.titleQuestion = new JLabel("Title of the piece:");
        this.tempoQuestion = new JLabel("Tempo: (40-216)");
        this.modeQuestion = new JLabel("Major/Minor");
        this.keyQuestion = new JLabel("Key:");
        
        // a music sheet is added to the master array list
        this.ok = new JButton("Ok");
        this.ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if (primaryKeyToEdit < 0 )
                    { 
                        musicSheet = new MusicSheet(getKey() , getPieceTitle() , getTempo() , getMode(),mainScreen.getNextPrimaryKey()+1);
                        mainScreen.addMusicSheet(musicSheet);
                         mainScreen.serializeMusicSheetList();
                    }
                    else
                    {
                        int musicsheetIndex = getMusicSheetIndexToEdit();
                        ArrayList<MusicSheet> musiclist = mainScreen.getMusicList();
                        musiclist.get(musicsheetIndex).setTitle(getPieceTitle());
                        musiclist.get(musicsheetIndex).setTempo(getTempo());
                        musiclist.get(musicsheetIndex).setMode(getMode());
                        musiclist.get(musicsheetIndex).setKey(getKey());
                        mainScreen.serializeMusicSheetList();
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

        if (primaryKeyToEdit >= 0 )
        {
            int musicsheetIndex = getMusicSheetIndexToEdit();
            if (musicsheetIndex < 0)
            {
                ErrorMessage err = new ErrorMessage();
                dispose();
                return;
            }
            else
            {
                MusicSheet musicsheet = this.mainScreen.getMusicList().get(musicsheetIndex);
                this.titleField.setText(musicsheet.getTitle());
                this.tempoField.setText(musicsheet.getTempo());
                this.majMinCmb.setSelectedItem(musicsheet.getMode());
                this.keyCmbList.setSelectedItem(musicsheet.getKey());
            }
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

    public int getMusicSheetIndexToEdit()
    {
        ArrayList<MusicSheet> musiclist = this.mainScreen.getMusicList();
        for(int i = 0; i < musiclist.size(); i++)
        {
            if(musiclist.get(i).getPrimaryKey() == this.primaryKeyToEdit)
            {
                return i;

            }

        }
        return -1;
    }
}
