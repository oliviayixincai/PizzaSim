import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Money displayer is a Greenfoot Actor used to display and update the current money of each kitchen 
 * 
 * @author Anson Ho
 * @version November 2022
 */
public class LevelDisplayer extends LabelDisplayer
{
    public LevelDisplayer(int value)
    {
        super(value);
    }
    
    public void act()
    {
        updateImage();
    }

    /**
     * Change the  value and rewrite it on the screen 
     */
    public void updateImage()
    {
        //display number for displayer
        GreenfootImage displayer = new GreenfootImage("Current Level: "+ getValue(), 25, Color.BLACK, transparent);
        setImage(displayer);
    }
}

