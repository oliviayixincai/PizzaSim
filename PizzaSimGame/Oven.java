import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oven extends Target
{
    private boolean isEmpty, isReserved = false;
    
    public Oven()
    {
        getImage().scale(50, 50);
        getImage().setTransparency(0);
    }
    
    public boolean checkIfEmpty()
    {
        if(isTouching(Pizza.class))
        {
            isEmpty = false;
        }
        else
        {
            isEmpty = true;
        }
        return isEmpty;
    }
    
    public void reserve(boolean reservation)
    {
        isReserved = reservation;
    }
    
    public boolean isReserved()
    {
        return isReserved;
    }
}
