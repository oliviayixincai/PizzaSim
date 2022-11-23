import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The robber seeks richness and spawns to take away money from the opponent store, ultimately attempting to stop the other store from winning
 * 
 * @author Eric Zheng 
 * @version November 2022
 */
public class Robber extends People
{
    private int store;
    private int location = 1, rotation;
    private boolean position = false, currentlyMovingToCashier;
    
    private GreenfootImage[] wf = new GreenfootImage[7];
    private GreenfootImage[] wb = new GreenfootImage[7];
    private GreenfootImage[] wl = new GreenfootImage[7];
    private GreenfootImage[] wr = new GreenfootImage[7];
    private GreenfootImage[] ai = new GreenfootImage[5];
    
    private GreenfootSound sound = new GreenfootSound("robbery.wav");
    //creates reference to access variable to change money values.
    private Utils utils;
    private MoneyInterface moneyInterface;
    private SettingWorld settingWorld;
    
    private boolean isCash2Open = false;
    private int enterDIR, exitDIR;
    
    public Robber(int store)
    {
        this.store = store;
        setImage("images/ra/f0.png");
        for(int i =0; i< 7; i++)
        {
            wf[i] = new GreenfootImage("images/ra/f" + i + ".png");
            wf[i].scale(85, 90);
            wb[i] = new GreenfootImage("images/ra/b" + i + ".png");
            wb[i].scale(85, 90);
            wl[i] = new GreenfootImage("images/ra/l" + i + ".png");
            wl[i].scale(85, 90);
            wr[i] = new GreenfootImage("images/ra/r" + i + ".png");
            wr[i].scale(85, 90);
        }
        
        for(int i = 0; i < 5; i++)
        {
            ai[i] = new GreenfootImage("images/ra/i" + i + ".png");
        }
    }

    public void act()
    {
        utils = getWorld().getObjectsAt(0, 0, Utils.class).get(0);
        animate(wb, wf, wl, wr, rotation);
        moveRobber();
    }
    
    /**
     * Method for calling move methods for robber based on location in world
     */
    public void moveRobber()
    {
        checkLocation();
        if(location == 1)
        {
            moveToDoor();
        }
        else if(location == 2) 
        {
            moveToCashier();
        }
        else if(location == 3)
        {
            exit();
        }
    }

    /**
     * Checks location of robber to set sequencing, and if
     */
    public void checkLocation()
    {
        if(getX() == 512 && getY() == Utils.enterY)
        {
            location = 2;
        }
        else if((getX() == Utils.cashier1X ||getX() == Utils.cashier4X) && getY() == Utils.counterY) //the robber robs when its at the cahsiercounter
        {
            stealMoney();
            location = 3;
        }
    }

    /**
     * Moves robber to the door of resturant 
     */
    public void moveToDoor()
    {
        if(getY() != 710)
        {
            rotation = DOWN;
            setLocation(getX(),getY()+1);
        }
    }

    /**
     * Moves robber to cashier of resturant
     */
    public void moveToCashier()
    {
        if(store == -1)
        {
            if(getX() != Utils.cashier1X)
            {
                rotation = LEFT;
                setLocation(getX() - 1, getY());
            }
            if((getX() == Utils.cashier1X || currentlyMovingToCashier) && getY() != Utils.counterY)
            {
                currentlyMovingToCashier = true;
                rotation = UP;
                setLocation(getX(), getY() - 1);
            }
        }
        else if(store == 1)
        {
            if(getX() != Utils.cashier4X)
            {
                rotation = RIGHT;
                setLocation(getX() + 1, getY());
            }
            if((getX() == Utils.cashier4X || currentlyMovingToCashier) && getY() != Utils.counterY)
            {
                currentlyMovingToCashier = true;
                rotation = UP;
                setLocation(getX(), getY() - 1);
            }
        }
    }

    /**
     * Moves robber to exit of the store and to the edge of the world
     */
    public void exit()
    {
        if(getY() != Utils.exitY)
        {
            rotation = DOWN;
            setLocation(getX(), getY() + 1);
        }
        if(store == -1)
        {
                if(getX() != 512)
                {
                    rotation = RIGHT;
                    setLocation(getX() + 1, getY());
                }
        }
        if(store == 1)
        {
                if(getX() != 512)
                {
                    rotation = LEFT;
                    setLocation(getX() - 1,getY());
                }
        }
        if(getX() == 512)
        {
            rotation = DOWN;
            setLocation(getX(), getY() + 1);
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Accesses money interface methods to change money of resturants
     */
    public void stealMoney()
    {
        moneyInterface = getWorld().getObjectsAt(0, 0, MoneyInterface.class).get(0);
        if(store == -1)
        {
            moneyInterface.changeMoney(store, utils.getRobbingMoneyPapa());
        }
        else
        {
            moneyInterface.changeMoney(store, utils.getRobbingMoneyMama());
        }
        sound.play();
    }
}
