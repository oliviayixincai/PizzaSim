import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        //Creates all oven objects
        addObject(new Oven(), 140, 190);
        addObject(new Oven(), 210, 190);
        addObject(new Oven(), 280, 190);
        
        addObject(new Pizza(), 60, 300);
        addObject(new Chef(110, 300, 100, 100), 110, 300);
        
        addObject(new Pizza(), 60, 380);
        addObject(new Chef(110, 380, 100, 100), 110, 380);
        
        //addObject(new Pizza(), 360, 307);
        //addObject(new Chef(360, 357), 360, 357);
        
        addObject(new Pizza(), 210, 190);
        //addObject(new Pizza(), 280, 190);
        
    }
}
