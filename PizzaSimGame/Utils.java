import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class used for editing and containing global static variables such as money of resturants and speed of characters.
 * 
 * @author Anson Ho
 * @version V1.0
 */
public class Utils extends Actor
{
    private int resturantMoneyOne = 0;
    private int resturantMoneyTwo = 0;
    private int resturantLevelOne = 1;
    private int resturantLevelTwo = 1;
    public static final int moveSpeed = 1;
  
    public static final int enterY = 710;
    public static final int exitY = 760;
    public static final int door1X = 449, door2X = 573;
    
    public static final int cashier1X = 333, cashier2X = 410, cashier3X = 614, cashier4X = 691;
    public static final int chefXLeft = 120, chefXRight = 904, chef1Y = 300, chef2Y = 400;
    
    public static final int wait1X = 160, wait2X = 222, wait3X = 280, wait4X = 744, wait5X = 802, wait6X = 864;
    
    public static final int kitchenCounterXLeft = 70, kitchenCounterXRight = 954, kitchenCounterY1 = 300, kitchenCounterY2 = 400;
    public static final int counterY = 610;
    
    public static final int oven1X = 160, oven2X = 222, oven3X = 280, oven4X = 744, oven5X = 802, oven6X = 864, ovenY = 190;
    public static final int pizzaFinalY = 550;
    
    public void resturantMoneyOneAdd(int money)
    {
        resturantMoneyOne += money;
    }
    
    public void resturantMoneyTwoAdd(int money)
    {
        resturantMoneyTwo += money;
    }
    
    public int getResturantMoneyOne()
    {
        return resturantMoneyOne;
    }
    
    public int getResturantMoneyTwo()
    {
        return resturantMoneyTwo;
    }
}
