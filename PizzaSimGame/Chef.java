import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chef here.
 * 
 * @author Anson Ho 
 * @version V.1
 */
public class Chef extends People
{
    
    public void act()
    {
        canPickUpPizza();
        
    }
    
    public void moveToOven(int ovenXCoord, int ovenYCoord)
    {
        
    }
    
    public void moveToCounter(int counterXCoord, int counterYCoord)
    {
        
    }
    
    public boolean canPickUpPizza()
    {
        boolean canPickUpPizza;
        Pizza pizza = (Pizza)getOneObjectAtOffset(getX(), getY() + getImage().getHeight() / 2, Pizza.class);
        if(pizza != null)
        {
            if(pizza.isFinished())
            {
                canPickUpPizza = true;
            }
        }
        else
        {
            canPickUpPizza = false;
        }
        return canPickUpPizza;
    }
    
    public void putPizzaInOven()
    {
        
    }
}
