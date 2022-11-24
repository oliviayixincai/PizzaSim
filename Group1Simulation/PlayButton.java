import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PLAY button to be clicked to start the simulation game.
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public class PlayButton extends Button
{
    public PlayButton() {
        super();
        // pre-load files
        this.image = new GreenfootImage("playButton.png");
        this.downImage = new GreenfootImage("playButtonDOWN.png");
        this.hoverImage = new GreenfootImage("playButtonHOVER.png");
    }
    
    /**
     * create a new MyWorld and put SettingWorld as a parameter of MyWorld.
     */
    protected void onClick() {
        SettingWorld sw = (SettingWorld) getWorld();
        Greenfoot.setWorld(new MyWorld(sw));
    }
}
