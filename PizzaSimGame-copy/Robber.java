import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        if(getX()<getWorld().getWidth()/2)
        {
            resturant = 1;
        }
        else if(getY()>getWorld().getWidth()/2)
        {
            resturant = 2;
        }
    }

    public void act()
    {
        // Add your action code here.
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
        Cashier c = (Cashier) getObjectsInRange(10,Cashier.class);
        {
            if(c != null)
            {
                setLocation(c.getX(),c.getY());
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

    }
