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
    private int location;
    private boolean stolen = false;
    private boolean position = false;
    private int imageIndexW = 0;
    private int imageIndexB = 0;
    private int imageIndexL = 0;
    private int imageIndexR = 0;
    private int imageIndexI = 0;
    private GreenfootImage[] wf = new GreenfootImage[7];
    private GreenfootImage[] wb = new GreenfootImage[7];
    private GreenfootImage[] wl = new GreenfootImage[7];
    private GreenfootImage[] wr = new GreenfootImage[7];
    private GreenfootImage[] ai = new GreenfootImage[5];
    
    private SimpleTimer tw = new SimpleTimer();
    private SimpleTimer tb = new SimpleTimer();
    private SimpleTimer tl = new SimpleTimer();
    private SimpleTimer tr = new SimpleTimer();
    private SimpleTimer ti = new SimpleTimer();
    private SimpleTimer it = new SimpleTimer();
    private Utils utils = new Utils();
    private MoneyInterface moneyInterface = new MoneyInterface(utils);
    private SettingWorld settingWorld = new SettingWorld();
    
    /**
     * Act - do whatever the Robber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Robber(int resturant)
    {
        this.resturant = resturant;
        setImage("images/ra/f0.png");
        for(int i =0; i< 7; i++)
        {
            wf[i] = new GreenfootImage("images/ra/f" + i + ".png");
            wb[i] = new GreenfootImage("images/ra/b" + i + ".png");
            wl[i] = new GreenfootImage("images/ra/l" + i + ".png");
            wr[i] = new GreenfootImage("images/ra/r" + i + ".png");
        }
        for(int i =0;i<5;i++)
        {
            ai[i] = new GreenfootImage("images/ri/tile00" + i + ".png");
        }
        tw.mark();
        tb.mark();
        tl.mark();
        tr.mark();
        ti.mark();
    }

    public void act()
    {

        // Add your action code here.
        if(stolen == false)
        {
            moveToDoorAndMoney();
            stealMoney();
            checkStolen();
        }
        if(stolen == true)
        {
            exit();
            checkPosition();
            if(position == true)
            {
                leave();
            }
        }
    }

    public void moveToDoorAndMoney()
    {
        checkLocation();
        if(location ==1)
        {
            move1();
        }
        else if(location ==2)
        {
            move2();
        }
        else if(location ==3)
        {
            move3();
        }
    }

    public void stealMoney()
    {
        it.mark();
        if(it.millisElapsed()<1000)
        {
        if(resturant ==1)
        {

            if(getX()==400&&getY()==630)
            {
                animateI();
                moneyInterface.changeMoney(1,settingWorld.getRobberStealMama()-((utils.getResturantLevelOne()-1)*5));
            }
        }
        if(resturant ==2)
        {

            if(getX()==610&&getY()==630)
            {
                animateI();
                moneyInterface.changeMoney(-1,settingWorld.getRobberStealPapa()-((utils.getResturantLevelTwo()-1)*5));
            }
        }
    }
    }

    public void checkLocation()
    {
        if(getX()==500&&getY()==100)
        {
            location =1;
        }
        else if(getX() == 500&&getY()==710)
        {
            location = 2;
        }
        else if((getX()==400||getX()==610)&&getY() ==710)
        {
            location =3;
        }

    }

    public void move1()
    {
        if(getY() != 710)
        {
            animateW();
            setLocation(getX(),getY()+1);
            
        }
    }

    public void move2()
    {
        if(resturant ==1)
        {
            if(getX() != 610)
            {
                animateR();
                setLocation(getX()+1,getY());
                
            }
        }
        else if(resturant == 2)
        {
            if(getX() != 400)
            {
                animateL();
                setLocation(getX()-1,getY());
            }
        }
    }

    public void move3()
    {
        if(getY() != 630)
        {
            animateB();
            setLocation(getX(),getY()-1);
        }
    }

    public void exit()
    {
        if(resturant == 1)
        {
           
            
                if(getX() != 500)
                {
                    animateL();
                    setLocation(getX()-1, getY());
                }
            
        }
        if(resturant == 2)
        {
            
            
                if(getX() != 500)
                {
                    animateR();
                    setLocation(getX()+1,getY());
                }
            
        }

    }

    public void leave()
    {
        if(getY() != 800)
        {
            animateW();
            setLocation(getX(),getY()+1);
        }
        if(getY() == 800)
        {
            
            getWorld().removeObject(this);
        }
    }

    public void checkStolen()
    {
        if((getX() == 400 || getX() == 610)&&getY() == 630)
        {

            stolen = true;
        }

    }
    public void checkPosition()
    {
        if(getX() == 500 && getY() == 630)
        {
            position = true;
        }
        
    }
    public void animateW()
    {
        
        if(tw.millisElapsed()>80)
        {
        setImage(wf[imageIndexW]);
        imageIndexW = (imageIndexW+1)%7;
        tw.mark();
    }
    }
    public void animateB()
    {
        
        if(tb.millisElapsed()>80)
        {
        setImage(wf[imageIndexB]);
        imageIndexB = (imageIndexB+1)%7;
        tb.mark();
    }
    }
    public void animateL()
    {
        
        if(tl.millisElapsed()>80)
        {
        setImage(wl[imageIndexW]);
        imageIndexL = (imageIndexL+1)%7;
        tl.mark();
    }
    }
    public void animateR()
    {
        
        if(tr.millisElapsed()>80)
        {
        setImage(wr[imageIndexR]);
        imageIndexR = (imageIndexR+1)%7;
        tr.mark();
    }
    }
    public void animateI()
    {
        if(ti.millisElapsed()>80&&imageIndexI<5)
            {
                setImage(ai[imageIndexI]);
                imageIndexI = (imageIndexI+1);
                
            }
    }

}
