import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class WaittingBar here.
 * 
 * @author Yixin Cai 
 * @version (a version number or a date)
 */
public class WaittingBar extends Actor
{
    private GifImage[] moodBarGif = new GifImage[6];
    
    private Customer c;
    private int gifIndex;
    private int increment = 2400; //time, changeable
    private int tips = 5;
    
    GreenfootSound angry = new GreenfootSound ("hmp.wav");
    
    private boolean playedSound = false;
    
    public WaittingBar(Customer c){
        this.c = c;
        
        for (int i = 0; i < moodBarGif.length; i++){
            moodBarGif[i] = new GifImage("mood" + i + ".gif");
            for (GreenfootImage img : moodBarGif[i].getImages()){
                img.scale((int)(img.getWidth() * 0.55), (int)(img.getHeight() * 0.55)); 
            }
        }
    }
    
    public void act(){
        //changes the gif based on individual customer wait timer
        //also changes how many tips they give
        if(c.getInStore() && c.getPickedUp() == false){
            if(c.getWaitTime() < increment){
                gifIndex = 0;
                tips = 5;
            } else if (c.getWaitTime() < (increment * 2)){
                gifIndex = 1;
                tips = 4;
            } else if (c.getWaitTime() < (increment * 3)){
                gifIndex = 2;
                tips = 3;
            } else if (c.getWaitTime() < (increment * 4)){
                gifIndex = 3;
                tips = 2;
            } else if (c.getWaitTime() < (increment * 5)){
                gifIndex = 4;
                tips = 1;
            } else {
                gifIndex = 5;
                tips = 0;
                
                //plays angry sound when super angry
                if (!playedSound){
                    angry.play();
                    playedSound = true;
                }
            }
            
            setImage(moodBarGif[gifIndex].getCurrentImage());
        } else if (c.getInStore() == false && c.getPickedUp() == true){
            
            /** MONEY INTERFACE
             * getWorld().addObject(new MoneyInterface(tips), x, y);
             */
            
            getWorld().removeObject(this);
        }
        
        //sets location based on customer
        setLocation(c.getX(), c.getY() + c.getImage().getHeight()/2 + 5);
    }
    
    /*private final int WAIT_DELAY = 420;
    private final int ROUND_COUNT = WAIT_DELAY / moodBarGif.length;
    
    private int tik;
    
    public WaittingBar() {
        tik = 0;
    }
    
    /**
     * Act - do whatever the WaittingBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     
    public void act()
    {
        setImage(moodBarGif[tik / ROUND_COUNT].getCurrentImage());
        tik++;
        
        if (tik > 420) {
            getWorld().removeObject(this);
        }
    }*/
}
