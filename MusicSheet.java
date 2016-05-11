import java.io.Serializable;

/**
 * An object which describes a music sheet. Contains the key, title, tempo, mode, and the primary 
 * key of the music sheet.
 * 
 * @author (Tong) 
 * @version (10 May 2016)
 */
public class MusicSheet implements Serializable
{
    // Variables which describe the music sheet object
    private String key;
    private String title;
    private String tempo;
    private String mode;
    private int primaryKey;

    /**
     * constructor for objects of class MusicSheet
     * 
     * takes in a key, title, tempo, mode, and primary key and assigns them to instance variables
     */
    public MusicSheet(String key , String title , String tempo , String mode,int primarykey)
    {
        // initialise instance variables
        this.key = key;
        this.title = title;
        this.tempo = tempo;
        this.mode = mode;
        this.primaryKey = primarykey;
    }

    /**
     * Gets the tempo of the music sheet
     *
     * @post   Gets the tempo of the music sheet
     * @return    returns the tempo of the music sheet as a String
     */
    public String getTempo()
    {
        // put your code here
        return this.tempo;
    }
    
    /**
     * Gets the key of the music sheet
     *
     * @post   Gets the key of the music sheet
     * @return    returns the key of the music sheet as a String
     */
    public String getKey()
    {
        return this.key;
    }
    
    /**
     * Gets the title of the music sheet
     *
     * @post   Gets the title of the music sheet
     * @return    returns the title of the music sheet as a String
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * Gets the mode of the music sheet
     *
     * @post   Gets the mode of the music sheet (major/minor)
     * @return    returns the mode of the music sheet as a String
     */
    public String getMode()
    {
        return this.mode;
    }
    
    /**
     * Gets the title of the music sheet
     *
     * @post   Gets the primary key of the music sheet
     */
    public int getPrimaryKey()
    {
        return this.primaryKey;
    }
    
    /**
     * Sets the title of the music sheet
     *
     * @post   sets the title of the music sheet
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Sets the tempo of the music sheet
     *
     * @post   sets the tempo of the music sheet
     */
    public void setTempo(String tempo)
    {
        this.tempo = tempo;
    }
    
    /**
     * Sets the mode (major/minor) of the music sheet
     *
     * @post   sets the mode of the music sheet
     */
    public void setMode(String mode)
    {
        this.mode = mode;
    }
    
    /**
     * Sets the key of the music sheet
     *
     * @post   sets the key of the music sheet
     */
    public void setKey(String key)
    {
        this.key = key;
    }
    
    /**
     * Sets the primary key of the music sheet
     *
     * @post   sets the primary key of the music sheet
     */
    public void setPrimaryKey()
    {
        this.primaryKey++;
    }
    
    /**
     * Overrides the object toString() method 
     *
     * @post   puts the information of the music sheet object into String form
     */
    @Override
    public String toString() {
           return new StringBuffer("")
           .append(this.primaryKey+"  ")
           .append(this.title+"    ")
           .append(this.mode+" ")
           .append(this.key+"  ")
           .append(this.tempo).toString();
          
       }
}

