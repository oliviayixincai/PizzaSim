import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates location and methods specifically for kichen counters
 * 
 * @author Anson Ho
 * @version November 2022
 */
public class KitchenCounter extends Target
{
    private boolean canMakePizza;
    private int pizzaria;
    
    public KitchenCounter(int pizzaria)
    {
        transparent();
        getImage().scale(25, 25);
        this.pizzaria = pizzaria;
    }
    /**
     * Checks if counter is available to make a pizza
     * @return canMakePizza Boolean
     */
    public boolean checkCanMakePizza()
    {
        if(isTouching(Pizza.class))
        {
            canMakePizza = false;
        }
        else if(!checkCounterChef())
        {
            canMakePizza = false;
        }
        else
        {
            canMakePizza = true;
        }
        return canMakePizza;
    }
    
    /**
     * Check if there is a chef around counter
     * @return boolean
     */
    public boolean checkCounterChef(){
        if(!getWorld().getObjectsAt(getX() - (50 * pizzaria), getY(), null).isEmpty()){
            return true;
        }
        else
        {
            return false;
        }
    }
}
