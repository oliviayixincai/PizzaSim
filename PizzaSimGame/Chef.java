import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math.*;

/**
 * Write a description of class Chef here.
 * 
 * @author Anson Ho 
 * @version V.1
 */
public class Chef extends People
{
    //Oven 1 Coords (temp) - x:48, y:397
    //Counter 1 Coords (temp) - x:210, y:317
    private int rotationIndex = 0;
    private int pizzaXOffset = 0, pizzaYOffset = -30;
    private double pizzaXCoord, pizzaYCoord, rotationIndexRadians;
    private boolean currentlyMovingPizza = false;
    private boolean canPickUp;
    public void act()
    {
        if(canPickUpPizza() || currentlyMovingPizza)
        {
            currentlyMovingPizza = true;
            moveToOven(48, 397);
        }
    }
    
    public void moveToOven(int ovenXCoord, int ovenYCoord)
    {
        boolean currentlyTurning;
        Pizza pizza = (Pizza)getOneObjectAtOffset(pizzaXOffset, pizzaYOffset, Pizza.class);
        if(rotationIndex != -90)
        {
            currentlyTurning = true;
            setRotation(rotationIndex -= 1); 
            rotationIndexRadians = Math.toRadians(rotationIndex * -1);
            System.out.println((30 * Math.cos(rotationIndex)));
            pizzaXCoord = getX() + (30 * Math.sin(rotationIndex));
            pizzaYCoord = getY() - (30 * Math.cos(rotationIndex));
            pizzaXOffset = (int)(30 * Math.sin(rotationIndex));
            pizzaYOffset = (int)(30 * Math.cos(rotationIndex));
            pizza.setLocation(pizzaXCoord, pizzaYCoord);
        }
        else
        {
            currentlyTurning = false;
        }
        /*
        if(rotationIndex == -90 && getY() != ovenYCoord)
        {
            setLocation(getX(), getY() + 1);
            pizzaYCoord -= 1;
            pizza.setLocation(pizzaXCoord, pizzaYCoord);
        }
        */
    }
    
    public void moveToCounter(int counterXCoord, int counterYCoord)
    {
        
    }
    
    public boolean canPickUpPizza()
    {
        Pizza pizza = (Pizza)getOneObjectAtOffset(pizzaXOffset, pizzaYOffset, Pizza.class);        
        if(pizza != null)
        {
            if(pizza.isFinished())
            {
                canPickUp = true;
            }
        }
        else
        {
            canPickUp = false;
        }
        return canPickUp;
    }
    
    public void putPizzaInOven()
    {
        
    }
}
