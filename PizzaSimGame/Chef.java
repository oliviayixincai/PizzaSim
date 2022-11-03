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
    //Oven 1 Coords (temp) - x:120, y:397
    //Counter 1 Coords (temp) - x:210, y:317
    private int rotationIndex = 0;
    private int ovenXCoord, ovenYCoord, counterXCoord, counterYCoord;
    private int pizzaXOffset = 0, pizzaYOffset = -50;
    private double pizzaXCoord, pizzaYCoord, rotationIndexRadians;
    private boolean currentlyMovingPizza = false;
    private boolean canPickUp;
    
    public Chef(int ovenXCoord, int ovenYCoord, int counterXCoord, int counterYCoord)
    {
        this.ovenXCoord = ovenXCoord;
        this.ovenYCoord = ovenYCoord;
        this.counterXCoord = counterXCoord;
        this.counterYCoord = counterYCoord;
    }
    
    public void act()
    {
        if(canPickUpPizza() || currentlyMovingPizza)
        {
            currentlyMovingPizza = true;
            moveToOven(ovenXCoord, ovenYCoord);
        }
        if(!currentlyMovingPizza)
        {
            moveToCounter(counterXCoord, counterYCoord);
        }
    }

    public void moveToOven(int ovenXCoord, int ovenYCoord)
    {
        Pizza pizza = (Pizza)getOneObjectAtOffset(pizzaXOffset, pizzaYOffset, Pizza.class);
        //rotate chef and pizza
        if(rotationIndex != -90)
        {
            setRotation(rotationIndex -= 1); 
            rotationIndexRadians = Math.toRadians(rotationIndex);
            pizzaXCoord = getX() + (50 * Math.sin(rotationIndexRadians));
            pizzaYCoord = getY() - (50 * Math.cos(rotationIndexRadians));
            pizzaXOffset = (int)(50 * Math.sin(rotationIndexRadians));
            pizzaYOffset = (int)(50 * Math.cos(rotationIndexRadians)) * -1;
            pizza.setLocation(pizzaXCoord, pizzaYCoord);
        }
        //move y axis to oven
        if(rotationIndex == -90 && getY() != ovenYCoord)
        {
            setLocation(getX(), getY() + 1);
            pizzaYCoord += 1;
            pizza.setLocation(pizzaXCoord, pizzaYCoord);
        }
        //move x axis to oven
        if(getY() == ovenYCoord && getX() != ovenXCoord)
        {
            setLocation(getX() - 1, getY());
            pizzaXCoord -= 1;   
            pizza.setLocation(pizzaXCoord, pizzaYCoord);
        }
        //reset boolean
        if(getX() == ovenXCoord && getY() == ovenYCoord)
        {
            currentlyMovingPizza = false;
        }
    }
    
    public void moveToCounter(int counterXCoord, int counterYCoord)
    {
        //move chef x axis to counter
        if(getX() != counterXCoord)
        {
            setLocation(getX() + 1, getY());
        }
        //rotate chef
        if(getX() == counterXCoord && rotationIndex != 0)
        {
            setRotation(rotationIndex += 1);
        }
        //move chef y axis to counter
        if(rotationIndex == 0 && getY() != counterYCoord)
        {
            setLocation(getX(), getY() - 1);
        }
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
    
    public boolean checkOpenOven()
    {
        
    }
}
