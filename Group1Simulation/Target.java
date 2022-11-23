import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Targets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Target extends Actor
{
    private boolean isEmpty, isReserved = false;
    protected GreenfootImage image;
    /**
     * Act - do whatever the Targets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /**
     * checks if there is a customer at this target
     * @return isEmpty, a boolean
     */
    public boolean checkIfEmpty()
    {
        if(getOneObjectAtOffset(0, 0, Customer.class) != null)
        {
            isEmpty = false;
        } else
        {
            isEmpty = true;
        }
        return isEmpty;
    }
    
    /**
     * sets the reservation to the param
     * @param reservation: sets a true (reserved) or false (not reserved) for the spot
     */
    public void reserve(boolean reservation)
    {
        isReserved = reservation;
    }
    
    public boolean isReserved()
    {
        return isReserved;
    }
    
    public void transparent (){
        getImage().setTransparency(0);
    }
}
