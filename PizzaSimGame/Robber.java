import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Robber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robber extends People
{
    private int resturant;
    /**
     * Act - do whatever the Robber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Robber()
    {
        
    }

    public void act()
    {
        // Add your action code here.
        checkRes();
        checkLocation();
        goForMoney();
        stealMoney();
    }

    public void checkLocation()
    {
        if(resturant ==1)
        {
            if(getX() != 780)
            {
                setLocation(getX()+1,getY());
            }
        }
        else if(resturant == 2)
        {
            if(getX() != 256)
            {
                setLocation(getX()-1,getY());
            }
        }
    }

    public void goForMoney(){
        ArrayList<Cashier> c = (ArrayList<Cashier>) getObjectsInRange(10,Cashier.class);
        for(Cashier ca : c)
        {
            if(ca != null)
            {
                setLocation(ca.getX(),ca.getY());
                getWorld().removeObject(this);
            }
        }
    }
    public void stealMoney()
    {
        if(getX()<getWorld().getWidth()/2)
        {
            Utils.resturantMoneyOne--;
        }
        else if(getY()>getWorld().getWidth()/2)
        {
            Utils.resturantMoneyTwo--;
            getWorld().removeObject(this);
        }
    }
    public void spawnRobber(int x , int y)
    {
        getWorld().addObject(new Robber(),x,y);
    }
    public void checkRes()
    {
        if(getX()<getWorld().getWidth()/2)
        {
            resturant = 1;
        }
        else if(getY()>getWorld().getWidth()/2)
        {
            resturant = 2;
        }
    }

    }
