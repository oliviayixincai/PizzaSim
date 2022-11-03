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
        addObject(new Pizza(), 210, 307);
        addObject(new Chef(120, 397, 210, 357), 210, 357);
        
        addObject(new Pizza(), 285, 307);
        addObject(new Chef(120, 497, 285, 357), 285, 357);
        
        addObject(new Pizza(), 360, 307);
        addObject(new Chef(120, 597, 360, 357), 360, 357);
        
    }
}
