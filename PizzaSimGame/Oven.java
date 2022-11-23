import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates location and methods specifically for ovens
 * 
 * @author Anson Ho
 * @version November 2022
 */
public class Oven extends Target
{
    private boolean isEmpty, isReserved = false, isPickUpReserved = false;
    
    public Oven()
    {
        transparent();
        getImage().scale(50, 50);
    }
    
    /**
     * Checks if oven is empty
     * @return isEmpty boolean
     */
    public boolean checkIfEmpty()
    {
        if(getOneObjectAtOffset(0, 0, Pizza.class) == null && !isTouching(OvenCover.class))
        {
            isEmpty = true;
        }
        else
        {
            isEmpty = false;
        }
        return isEmpty;
    }
    
    /**
     * Checks if pizza is ready to be picked up
     * @return boolean
     */
    public boolean canPickUp()
    {
        if(!checkIfEmpty() && !isTouching(OvenCover.class))
        {
            Pizza pizza = (Pizza) getOneObjectAtOffset(0, 0, Pizza.class);
            if(pizza.isCooked())
            {
                return true;
            }
            return false;
        }
        return false;
    }
    
    /**
     * Method to reserve oven for cashier pickup
     */
    public void pickUpReserve(boolean reservation)
    {
        isPickUpReserved = reservation;
    }
    
    /**
     * Method to reserve oven for chef dropoff
     */
    public void reserve(boolean reservation)
    {
        isReserved = reservation;
    }
    
    /**
     * Getter method to check if oven is reserved for dropoff
     * @return isReserved Boolean
     */
    public boolean isReserved()
    {
        return isReserved;
    }
    
    /**
     * Getter method to check if oven is reserved for pickup
     * @return isPickUpReserved Boolean
     */
    public boolean isPickUpReserved()
    {
        return isPickUpReserved;
    }
}
