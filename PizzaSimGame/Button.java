import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button is the main abstract class for various buttons in this simulation.
 * It supports basic effect, such as click sound, hover effect, and click effect.
 * 
 * It supports multiple clicks and the click sound will play for each click.
 * 
 * Specific onClick effects are delegated to subclasses by abstract onClick class.
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public abstract class Button extends Actor implements ISound
{   
    // Declare and initialize vaiables and objects
    protected GreenfootImage image;
    protected GreenfootImage downImage;
    protected GreenfootImage hoverImage;

    // pre-load sound files
    private static GreenfootSound[] sounds = {
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav")
    };
    private int soundNum;
    private int soundIndex;
    private int downTik;
    private boolean isHovered;
    
    /**
     * Constructor for objects of class Button.
     */
    public Button() {
        this.downTik = 0;
        this.soundNum = sounds.length;
        this.soundIndex = 0;
        this.isHovered = false;
    }
    
    /**
     * Once it is added to the world, set sound volume.
     * @param w a World
     */
    public void addedToWorld(World w) {
        // update volume after being added to world
        for (GreenfootSound sound : sounds) {
            sound.setVolume(Utils.volume);
        }
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * do onclick behaviour, clicked, hover effect and play sound.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            downTik = 5;
            onClick();
            playSound();
        }
        else if (Greenfoot.mouseMoved(this)) {
            isHovered = true;
        }
        else if (Greenfoot.mouseMoved(null)) {
            isHovered = false;
        }
        
        if (downTik > 0) {
            setImage(downImage);
            downTik--;
        }
        else if (isHovered) {
            setImage(hoverImage);
        }
        else {
            setImage(image);
        }
    }
    
    /**
     * Specific onClick effects to be implemented by subclasses
     */
    protected abstract void onClick();
    
    /**
     * Start playing sound if there is sound
     */
    public void playSound() {
        soundIndex++;
        if (soundIndex > (sounds.length - 1)) {
            soundIndex = 0;
        }
        sounds[soundIndex].play();
    }
    
    /**
     * Pause playing sound if there is sound
     */
    public void pauseSound() {
        sounds[soundIndex].pause();
    }

    /**
     * Method to determine weather sound is playing.
     * @return boolean True if the sound is playing, False otherwise.
     */
    public boolean isSoundPlaying () {
        return sounds[soundIndex].isPlaying();
    }
    
    /**
     * Method to get the sound in specific index.
     * @return GreenfootSound the greenfoot sound
     */
    public GreenfootSound getSound (){
        return sounds[soundIndex];
    }
    
    /**
     * Update volume of the sounds
     * @param volume The current volume
     */
    public void setVolume(int volume) {
        for (GreenfootSound sound : sounds) {
            sound.setVolume(volume);
        }
    }
}
