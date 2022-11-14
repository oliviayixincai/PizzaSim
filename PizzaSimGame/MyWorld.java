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
        if(Utils.resturantMoneyOne>5)
        {
            spawnRobber1(500,100);
        }
        if(Utils.resturantMoneyTwo>5)
        {
            spawnRobber2(500,100);
        }
        spawnRobber1(500,100);
    }
    public void spawnRobber1(int x , int y)
    {
        addObject(new Robber(1),x,y);
    }
    public void spawnRobber2(int x, int y)
    {
        addObject(new Robber(2),x,y);
    }
    
    
}
