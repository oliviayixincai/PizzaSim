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
    public Robber(int resturant)
    {
        this.resturant = resturant;

    }

    public void act()
    {
        // Add your action code here.
        moveToDoorAndMoney();

        stealMoney();
    }

    public void moveToDoorAndMoney()
    {
        if(getY() != 710)
        {
            setLocation(getX(),getY()+1);
        }
        else if(getY() == 710)
        {
            if(resturant ==1)
            {
                if(getX() != 610)
                {
                    setLocation(getX()+1,getY());
                }
            }
            else if(resturant == 2)
            {
                if(getX() != 400)
                {
                    setLocation(getX()-1,getY());
                }
            }
        }
        if(getY() == 710 && (getX() == 400 || getX() == 610))
        {
            if(getY() != 630)
            {
             setLocation(getX(),getY()-1);
            }
        }
    }

    public void stealMoney()
    {
        if(resturant ==1)
        {

            if(getX()==400&&getY()==630)
            {
                Utils.resturantMoneyOne--;
                getWorld().removeObject(this);
            }
        }
        if(resturant ==2)
        {

            if(getX()==610&&getY()==630)
            {
                Utils.resturantMoneyTwo--;
                getWorld().removeObject(this);
            }
        }
    }

}
