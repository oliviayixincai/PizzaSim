import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Volume button to control volume of the sounds in the simulation game.
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public class VolumeButton extends Button
{
    private boolean isUp;
    
    /**
     * Constructor of VolumeButton
     * @param isUp True if the volume is going to up, False otherwise.
     */
    public VolumeButton(boolean isUp) {
        super();
        this.isUp = isUp;
        // Set up images if it is up
        if (isUp) {
            this.image = new GreenfootImage("volumeUp.png");
            this.downImage = new GreenfootImage("volumeUpDown.png");
            this.hoverImage = new GreenfootImage("volumeUpHover.png");
        }
        // Set up images if it is down
        else {
            this.image = new GreenfootImage("volumeDown.png");
            this.downImage = new GreenfootImage("volumeDownDown.png");
            this.hoverImage = new GreenfootImage("volumeDownHover.png");
        }
    }
    
    /**
     * Update volumes in both MyWorld and SettingWorld.
     */
    public void onClick() {
        World world = getWorld();
        if (world instanceof MyWorld) {
            MyWorld mw = (MyWorld) world;
            mw.updateVolume(isUp);
        }
        else if (world instanceof SettingWorld) {
            SettingWorld sw = (SettingWorld) world;
            sw.updateVolume(isUp);
        }
    }
}
