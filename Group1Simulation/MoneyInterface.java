import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class that allows all other classes to interact with money variable in utils
 * 
 * @author Anson Ho
 * @version November 2022
 */
public class MoneyInterface extends Actor
{
    private Utils utils;
    
    public MoneyInterface(Utils utils)
    {
        this.utils = utils;
        getImage().setTransparency(0);
    }
    
    /**
     * Allows any actor to be able to change the money of each store
     * @param store Referring to which store
     * @param money Integer to change variable by
     */
    public void changeMoney(int store, int money)
    {
        if(store == -1)
        {
            utils.resturantMoneyOneAdd(money);
            MoneyDisplayer money_displayer = (MoneyDisplayer)getWorld().getObjectsAt(213, 25, MoneyDisplayer.class).get(0);
            money_displayer.setDisplayer(utils.getResturantMoneyOne());
        }
        if(store == 1)
        {
            utils.resturantMoneyTwoAdd(money);
            MoneyDisplayer money_displayer = (MoneyDisplayer)getWorld().getObjectsAt(795, 25, MoneyDisplayer.class).get(0);
            money_displayer.setDisplayer(utils.getResturantMoneyTwo());
        }
    }
}
