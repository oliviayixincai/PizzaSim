import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract class that has getter method for checks required for logic
 * 
 * @author Anson Ho
 * @version November 2022
 */
public abstract class Target extends Actor
{
    private boolean isEmpty, isReserved = false;
    protected GreenfootImage image;
    
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
    
    /**
     * Returns a boolean indicating whether or not it is reserved or not
     * @return isReserved Boolean
     */
    public boolean isReserved()
    {
        return isReserved;
    }
    
    public void transparent (){
        getImage().setTransparency(0);
    }
}
