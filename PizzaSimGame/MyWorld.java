import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private boolean isSimOver;
    private SettingWorld settingWorld;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(SettingWorld settingWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        this.settingWorld = settingWorld;
        isSimOver = false;
        
        addObject(new Oven(), 140, 190);
        addObject(new Oven(), 210, 190);
        addObject(new Oven(), 280, 190);
        addObject(new Cashier(340, 430, 100, 100), 330, 460);
        addObject(new Pizza(), 280, 190);
    }
    
    public void act() {
        
    }
    
    public void removeAllActors() {
        ArrayList<Actor> actors = (ArrayList) getObjects(null);
        for(Actor actor : actors) {
           removeObject(actor); 
        }
    }
    
    public boolean checkSimOver() {
        return this.isSimOver;
    }
    
    public void setUpNewSim() {
        
    }
    
    public void stopped() {
        // stop all sounds
        ArrayList<ISoundCentre> sounds = (ArrayList<ISoundCentre>) getObjects(ISoundCentre.class);
        for (ISoundCentre sound : sounds) {
            sound.stopSound();
        }
        // stop background sound
        BackgroundSound.getInstance().stopSound();
    }
    
    public void started() {
        // play all sounds
        ArrayList<ISoundCentre> sounds = (ArrayList<ISoundCentre>) getObjects(ISoundCentre.class);
        for (ISoundCentre sound : sounds) {
            sound.playSound();
        }
        // play background sound in loop
        BackgroundSound.getInstance().playSound();
    }
}
