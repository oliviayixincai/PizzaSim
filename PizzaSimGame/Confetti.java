import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to hold the confetti effect in the EndWord.
 * 
 * Credits
 * (https://www.canva.com/).
 * 
 * @author Yixin Cai
 * @version November 2022
 */

public class Confetti extends Actor implements ISound
{
    // declare objects
    private GifImage confetti;
    private GreenfootSound winSound;
    
    /**
     * Constructor of Confetti
     */
    public Confetti() {
        // initialize and pre-load
        confetti = new GifImage("confetti.gif");
        winSound = new GreenfootSound("win.wav");
        // set gif images
        setImage(confetti.getCurrentImage());
    }
    
    /**
     * Once it is added into World, set volume and play sound.
     * @param w a World
     */
    public void addedToWorld(World w) {
        winSound.setVolume(Utils.volume);
        playSound();
    }
    
    /**
     * Act - do whatever the confetti wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * update and set gif images
     */
    public void act()
    {
        setImage(confetti.getCurrentImage());
    }
    
    /**
     * Set volume
     * @param volume The current volume
     */
    public void setVolume(int volume) {
        winSound.setVolume(volume);
    }
    
    /**
     * Play sound
     */
    public void playSound() {
        winSound.play();
    }
    
    /**
     * Pause sound
     */
    public void pauseSound() {
        winSound.pause();
    }
    
    /**
     * Check if sound is playing
     * @return boolean True if the sound is playing, False otherwise.
     */
    public boolean isSoundPlaying() {
        return winSound.isPlaying();
    }
    
    /**
     * Get sound
     * @return GreenfootSound a GreenfootSound sound
     */
    public GreenfootSound getSound() {
        return winSound;
    }
}
