import greenfoot.*;
/**
 * Interface for actors that has sound effect. This is used to collect all such objects in World.
 * 
 * @author Yixin Cai
 * @version November 2022
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
     * @return boolean True if the sound is playing, False otherwise.
     */
    public boolean isSoundPlaying();
    
    /**
     * Get sound
     * @return GreenfootSound a GreenfootSound sound
     */
    public GreenfootSound getSound();
}
