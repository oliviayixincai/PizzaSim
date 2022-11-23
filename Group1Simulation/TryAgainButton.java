import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TryAgain button to be displayed in the EndWorld. To be clicked to start over.
 * 
 * @author Yixin Cai
 * @version (a version number or a date)
 */
public class TryAgainButton extends Button
{
    private MyWorld myWorld;
    
    public TryAgainButton() {
        super();
        
        this.image = new GreenfootImage("tryAgain.png");
        this.downImage = new GreenfootImage("tryAgainDOWN.png");
        this.hoverImage = new GreenfootImage("tryAgainHOVER.png");
    }
    
    protected void onClick() {
        //myWorld.removeAllActors();
        //set up a new sim
        Greenfoot.setWorld(new StartWorld());
    }
}
