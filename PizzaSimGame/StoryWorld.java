import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A World that tells a backgroud story about this simulation game.
 * Click any place on the screen to continue.
 * 
 * Credits
 * "Living Room" by Emily Nyugen from Dribbble (https://dribbble.com/shots/15230747-living-room).
 * "Gordon Ramsay - Pixel Person" from OpenSea (https://opensea.io/assets/ethereum/0x495f947276749ce646f68ac8c248420045cb7b5e/106193816756882454311635148036298702300189172230297614362597037732657916542977).
 * 
 * @author Gloria Chan & Yixin Cai
 * @version November 2022
 */
public class StoryWorld extends World
{
    // Declare vatiables and objects
    private int clickIndex;
    private FlashingText nextPageText;
    private static GreenfootImage[] storyPanels;
    
    /**
     * Constructor for objects of class storyWorld.
     * 
     */
    public StoryWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        clickIndex = 1;
        // pre-load files
        nextPageText = new FlashingText(new GreenfootImage("toNextPageText.png"));
        storyPanels = new GreenfootImage[] {
            new GreenfootImage("JordanRamseyPanel1 copy.png"),
            new GreenfootImage("JordanRamseyPanel2 copy.png"),
            new GreenfootImage("StoryPanel1.png"), 
            new GreenfootImage("StoryPanel2.png"), 
            new GreenfootImage("StoryPanel3.png"), 
            new GreenfootImage("StoryPanel4.png"),
        };
        // set background image and text
        setBackground(storyPanels[0]);
        addObject(nextPageText, 500, 700);
    }
    
    /**
     * If player press any place in the simulation, fo to the next page.
     * If it is in the last page, go to the SettingWorld once clicked.
     */
    public void act() {
        if (checkClicked() && clickIndex < 6) {
            setBackground(storyPanels[clickIndex]);
            clickIndex++;
        }
        else if(clickIndex == 6 && checkClicked()) {
            Greenfoot.setWorld(new SettingWorld());
        }
    }
    
    /**
     * Method to check if mouse clicked the background 
     * image and the falshing text object as well.
     * @return boolean True if mouse clicked the background image and 
     * the falshing text object, False otherwise.
     */
    private boolean checkClicked() {
        return Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(nextPageText);
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
