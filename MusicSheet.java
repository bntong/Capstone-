import java.io.Serializable;

/**
 * Write a description of class MusicSheet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicSheet implements Serializable
{
    /** description of instance variable x (add comment for each instance variable) */
    private String key;
    private String title;
    private String tempo;
    private String mode;
    private int primaryKey;

    /**
     * Default constructor for objects of class MusicSheet
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
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public String getTempo()
    {
        // put your code here
        return this.tempo;
    }
    
    public String getKey()
    {
        return this.key;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public String getMode()
    {
        return this.mode;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setTempo(String tempo)
    {
        this.tempo = tempo;
    }
    public void setMode(String mode)
    {
        this.mode = mode;
    }
    public void setKey(String key)
    {
        this.key = key;
    }
    public void setPrimaryKey()
    {
        this.primaryKey++;
    }
    public int getPrimaryKey()
    {
        return this.primaryKey;
    }
    @Override
    public String toString() {
    	   return new StringBuffer("")
    	   .append(this.primaryKey+"   ")
    	   .append(this.title+"    ")
    	   .append(this.mode+" ")
    	   .append(this.key+"  ")
    	   .append(this.tempo).toString();
    	  
	   }
}

