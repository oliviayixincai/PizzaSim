import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The World this simulation will start with. Press Enter key to continue.
 * 
 * Credits
 * "Pixel Chef Illustrations" from iStock (https://www.istockphoto.com/vector/vector-pixel-art-cook-and-chefs-gm616129156-107107145).
 * "Sprout Lands - UI Pack" by Cup Nooble (https://cupnooble.itch.io/sprout-lands-ui-pack).
 * "Slice of Life" from Pinterest (https://www.pinterest.ca/pin/349099408595478913/).
 * 
 * @author Yixin Cai & Gloria Chan
 * @version November 2022
 */
public class StartWorld extends World
{
    // Declare variables
    private FlashingText text;
    private GreenfootImage image;
    
    /**
     * Constructor for objects of class StartWorld.
     */
    public StartWorld()
    {   
        // Create a new world with 1024x800 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        // initialize variables and objects
        //This creates a blinking "press enter to continue" text.
        // pre-load files
        text = new FlashingText(new GreenfootImage ("enterToPlay.png")); 
        image = new GreenfootImage ("StartScreen.png");
        Utils.volume = 80;
        Utils.backgroundSound.setVolume(Utils.volume);
        // Initialize all the volumes in the constructor to make sure when the simulation
        // started, the volume can be setted properly.
        ArrayList<ISound> sounds = (ArrayList<ISound>) getObjects(ISound.class);
        for (ISound sound : sounds) {
            sound.setVolume(Utils.volume);
        }
        Utils.backgroundSound.setVolume(Utils.volume);
        setBackground(image);
        // add blinking text
        addObject(text,500,450);
    }
    
    /**
     * Act - do whatever the StartWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Go to the story world once the player press enter key.
     */
    public void act() {
        // Go to the story world once the player press enter key.
        if (Greenfoot.isKeyDown("Enter")) {
            Greenfoot.setWorld(new StoryWorld());
        }
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Utils.backgroundSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Utils.backgroundSound.pause();
    }
}
