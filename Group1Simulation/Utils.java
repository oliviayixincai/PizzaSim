import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class used for editing and containing global static variables such as money of resturants and speed of characters.
 * 
 * @author Anson Ho/Andy
 * @version November 2022
 */
public class Utils extends Actor
{
    /**
     * Constructor of Utilities class
     */
    public Utils()
    {
        getImage().setTransparency(0);
        
        volume = 80;
        numberOfCustomers1 = 0;
        numberOfCustomers2 = 0;
    }
    
    private int resturantMoneyOne = 0;
    private int resturantMoneyTwo = 0;
    private int resturantLevelOne = 1;
    private int resturantLevelTwo = 1;
    private int robbingMoneyMama, robbingMoneyPapa;
    public static final int moveSpeed = 1;
    
    public static int volume;
    public static final GreenfootSound backgroundSound = new GreenfootSound("Run-Amok.wav");
    
    public static final int enterY = 710;
    public static final int exitY = 760;
    public static final int door1X = 449, door2X = 573;
    
    public static final int cashier1X = 333, cashier2X = 410, cashier3X = 614, cashier4X = 691, cashierY = 460;
    public static final int chefXLeft = 120, chefXRight = 904, chef1Y = 250, chef2Y = 325, chef3Y = 400;
    
    public static final int wait1X = 160, wait2X = 222, wait3X = 280, wait4X = 744, wait5X = 802, wait6X = 864;
    
    public static final int kitchenCounterXLeft = 70, kitchenCounterXRight = 954, kitchenCounterY1 = 250, kitchenCounterY2 = 325, kitchenCounterY3 = 400;
    public static final int counterY = 610;
    
    public static final int oven1X = 160, oven2X = 222, oven3X = 280, oven4X = 864, oven5X = 802, oven6X = 744, ovenY = 190;
    public static final int pizzaFinalY = 550;
    
    public static final int MAMA = -1, PAPA = 1;
    
    public static int numberOfCustomers1, numberOfCustomers2;

    /**
     * Method to add number of customers in store 1 by 1
     */
    public void addCustomer1(){
        numberOfCustomers1++;
    }
    
    /**
     * Method to add number of customers in store 2 by 1
     */
    public void addCustomer2(){
        numberOfCustomers2++;
    }
    
    /**
     * Method to remove number of customers in store 1 by 1
     */
    public void removeCustomer1(){
        numberOfCustomers1--;
    }
    
    /**
     * Method to remove number of customers in store 2 by 1
     */
    public void removeCustomer2(){
        numberOfCustomers2--;
    }
    
    /**
     * Setter method to change total money of store 1
     * @param money Amount of money to change by
     */
    public void resturantMoneyOneAdd(int money)
    {
        resturantMoneyOne += money;
    }
    
    /**
     * Setter method to change total money of store 2
     * @param money Amount of money to change by
     */
    public void resturantMoneyTwoAdd(int money)
    {
        resturantMoneyTwo += money;
    }
    
    /**
     * Setter method to change total money that robber robs from store 1
     * @param money Amount of money to change by
     */
    public void setRobbingMoneyMama(int money)
    {
        robbingMoneyMama = robbingMoneyMama + money;
    }
    
    /**
     * Setter method to change total money that robber robs from store 2
     * @param money Amount of money to change by
     */
    public void setRobbingMoneyPapa(int money)
    {
        robbingMoneyPapa = robbingMoneyPapa + money;
    }
    
    /**
     * Method to add 1 level to store 1
     */
    public void addResturantLevelOne()
    {
        resturantLevelOne++;
    }

    /**
     * Method to add 1 level to store 2
     */
    public void addResturantLevelTwo()
    {
        resturantLevelTwo++;
    }
    
    /**
     * Getter method to get total money of store 1
     * @return resturantMoneyOne
     */
    public int getResturantMoneyOne()
    {
        return resturantMoneyOne;
    }
    
    /**
     * Getter method to get total money of store 2
     * @return resturantMoneyTwo
     */
    public int getResturantMoneyTwo()
    {
        return resturantMoneyTwo;
    }
    
    /**
     * Getter method to get level of store 1
     * @return resturantLevelOne
     */
    public int getResturantLevelOne()
    {
        return resturantLevelOne;
    }

    /**
     * Getter method to get level of store 2
     * @return resturantLevelTwo
     */
    public int getResturantLevelTwo()
    {
        return resturantLevelTwo;
    }
    
    /**
     * Getter method to get amount of money robber robs from store 2
     * @return robbingMoneyMama
     */
    public int getRobbingMoneyMama()
    {
        return robbingMoneyMama;
    }
    
    /**
     * Getter method to get amount of money robber robs from store 1
     * @return robbingMoneyMama
     */
    public int getRobbingMoneyPapa()
    {
        return robbingMoneyPapa;
    }
}
