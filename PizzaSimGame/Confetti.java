import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class confetti here.
 * 
 * @author Yixin Cai
 * @version (a version number or a date)
 */
<<<<<<< HEAD
public class Confetti extends Effects
{
    private GifImage confetti;
    
    public Confetti() {
        confetti = new GifImage("confetti.gif");
        setImage(confetti.getCurrentImage());
=======
public class Confetti extends Actor implements ISound
{
    private GifImage confetti;
    private GreenfootSound winSound;
      
    public Confetti() {
        confetti = new GifImage("confetti.gif");
        winSound = new GreenfootSound("win.wav");
        setImage(confetti.getCurrentImage());
        //playSound();
    }
    
    public void addedToWorld(World w) {
        winSound.setVolume(Utils.volume);
        playSound();
>>>>>>> main
    }
    
    /**
     * Act - do whatever the confetti wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(confetti.getCurrentImage());
    }
<<<<<<< HEAD
=======
    
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
>>>>>>> main
}
