import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class only for covering up cashier till using an image
 * 
 * @author Anson Ho
 * @version November 2022
 */
public class CashierCover extends LevelUp
{
    public CashierCover(String store)
    {
        GreenfootImage cover = new GreenfootImage("cashier cover " + store + ".png");
        setImage(cover);
    }
}
