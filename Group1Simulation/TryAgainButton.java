import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TryAgain button to be displayed in the EndWorld. To be clicked to start over.
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public class TryAgainButton extends Button
{
    private MyWorld myWorld;
    
    public TryAgainButton() {
        super();
        // pre-load files
        this.image = new GreenfootImage("tryAgain.png");
        this.downImage = new GreenfootImage("tryAgainDOWN.png");
        this.hoverImage = new GreenfootImage("tryAgainHOVER.png");
    }
    
    /**
     * Set up a new simulation
     */
    protected void onClick() {
        // create a new StartWorld
        Greenfoot.setWorld(new StartWorld());
    }
}
