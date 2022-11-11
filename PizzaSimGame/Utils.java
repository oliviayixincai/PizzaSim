import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class used for editing and containing global static variables such as money of resturants and speed of characters.
 * 
 * @author Anson Ho
 * @version V1.0
 */
public class Utils extends Actor
{
    private static int resturantMoneyOne = 0;
    private static int resturantMoneyTwo = 0;
    private static int resturantLevelOne = 1;
    private static int resturantLevelTwo = 1;
    private static int moveSpeed = 1;
    private static boolean ovenOneEmpty, ovenTwoEmpty, ovenThreeEmpty;
      
    public static int getResturantMoneyOne()
    {
        return resturantMoneyOne;
    }
    
    public static int getResturantMoneyTwo()
    {
        return resturantMoneyTwo;
    }
    
    public static int getResturantLevelOne()
    {
        return resturantLevelOne;
    }
    
    public static int getResturantLevelTwo()
    {
        return resturantLevelTwo;
    }
    
    public static int getMoveSeed()
    {
        return moveSpeed;
    }
}
