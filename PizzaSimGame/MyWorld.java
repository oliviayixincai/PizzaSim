import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int dir;
    private int dirRNG;
    
    private int startingY;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        addObject(new Door(), Utils.door1X, Utils.doorY);
        addObject(new Door(), Utils.door2X, Utils.doorY);
        
        addObject(new CashierCounter(), Utils.cashier1X, Utils.cashierY);
        addObject(new CashierCounter(), Utils.cashier2X, Utils.cashierY);
    }
    
    public void act () {
        spawnCustomer();
    }
    
    public void spawnCustomer(){
        dirRNG = Greenfoot.getRandomNumber(2);
        
        if(dirRNG == 1){
            dir = 1;
            startingY = 153;
        } else if (dirRNG == 0) {
            dir = -1;
            startingY = getHeight();
        }
        
        int rng = Greenfoot.getRandomNumber(60);
        
        if (rng == 0){
            addObject(new Customer(dir), Greenfoot.getRandomNumber(160) + 440, startingY);
        }
    }
}
