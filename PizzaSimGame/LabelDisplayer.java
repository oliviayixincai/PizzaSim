import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Money displayer is a Greenfoot Actor used to display and update the current money of each kitchen 
 * 
 * @author Anson Ho
 * @version November 2022
 */
public abstract class LabelDisplayer extends Actor
{
    
    private int value;
    protected static final Color transparent = new Color(0,0,0,0);
    /**
     * Store the initial value of the label 
     * @param value Initial value of the label
     */
    public LabelDisplayer(int value){
        this.value = value;
    }
    
    /**
     * when the value displayer is added to world, show the initial value
     */
    public void addedToWorld(World w){
        setDisplayer(value);
    }
    
    /**
     * set the new value of displayer and update the displayer
     * @param newValue new value of value 
     */
    public void setDisplayer(int newValue)
    {
        value = newValue;
    }
    
    /**
     * return the current value of label
     */
    public int getValue(){
        return value;
    }
}

