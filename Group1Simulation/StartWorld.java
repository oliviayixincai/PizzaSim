import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The World this simulation will start with. Press Enter key to continue
 * 
 * Credits
 * "Pixel Chef Illustrations" from iStock (https://www.istockphoto.com/vector/vector-pixel-art-cook-and-chefs-gm616129156-107107145).
 * "Sprout Lands - UI Pack" by Cup Nooble (https://cupnooble.itch.io/sprout-lands-ui-pack).
 * "Slice of Life" from Pinterest (https://www.pinterest.ca/pin/349099408595478913/).
 * 
 * @author Yixin Cai & Gloria Chan
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    // initialize variables
    private FlashingText text;
    private GreenfootImage image;
    
    /**
     * Constructor for objects of class StartWorld.
     */
    public StartWorld()
    {   
        // Create a new world with 1024x800 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        text = new FlashingText(new GreenfootImage ("enterToPlay.png")); //This creates a blinking "press enter to continue" text.
        image = new GreenfootImage ("StartScreen.png");
        Utils.volume = 80;
        Utils.backgroundSound.setVolume(Utils.volume);
        ArrayList<ISound> sounds = (ArrayList<ISound>) getObjects(ISound.class);
        for (ISound sound : sounds) {
            sound.setVolume(Utils.volume);
        }
        Utils.backgroundSound.setVolume(Utils.volume);
        setBackground(image);
        addObject(text,500,450);
    }
    
    public void act() {
       if (Greenfoot.isKeyDown("Enter")) {
           Greenfoot.setWorld(new StoryWorld());
       }
    }
    
    public void started() {
        Utils.backgroundSound.playLoop();
    }
    
    public void stopped() {
        Utils.backgroundSound.pause();
    }
}
