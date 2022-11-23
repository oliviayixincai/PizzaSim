import greenfoot.*;
/**
 * Interface for actors that has sound effect. This is used to collect all such objects in World.
 * 
 * @author Yixin Cai
 * @version (a version number or a date)
 */
public interface ISound
{
    /**
     * Set volume
     * @param volume The current volume
     */
    public void setVolume(int volume);
    
    /**
     * Play sound
     */
    public void playSound();
    
    /**
     * Pause sound
     */
    public void pauseSound();
    
    /**
     * Check if sound is playing
     */
    public boolean isSoundPlaying();
    
    /**
     * Get sound
     */
    public GreenfootSound getSound();
}
