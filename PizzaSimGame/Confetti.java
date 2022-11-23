import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to hold the confetti effect in the EndWord.
 * 
 * @author Yixin Cai
 * @version (a version number or a date)
 */

public class Confetti extends Actor implements ISound
{
    private GifImage confetti;
    private GreenfootSound winSound;
      
    public Confetti() {
        confetti = new GifImage("confetti.gif");
        winSound = new GreenfootSound("win.wav");
        setImage(confetti.getCurrentImage());
    }
    
    public void addedToWorld(World w) {
        winSound.setVolume(Utils.volume);
        playSound();
    }
    
    /**
     * Act - do whatever the confetti wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
     */
    public boolean isSoundPlaying() {
        return winSound.isPlaying();
    }
    
    /**
     * Get sound
     */
    public GreenfootSound getSound() {
        return winSound;
    }
}
