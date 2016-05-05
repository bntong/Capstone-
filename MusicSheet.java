

/**
 * Write a description of class MusicSheet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicSheet
{
    /** description of instance variable x (add comment for each instance variable) */
    private String key;
    private String title;
    private int tempo;

    /**
     * Default constructor for objects of class MusicSheet
     */
    public MusicSheet(String key , String title , int tempo)
    {
        // initialise instance variables
        this.key = key;
        this.title = title;
        this.tempo = tempo;
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
    public int getTempo()
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

}
