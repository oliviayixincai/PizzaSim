import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private boolean isSimOver, changedLevelTwoLeft, changedLevelTwoRight, changedLevelThreeLeft, changedLevelThreeRight;
    private SettingWorld settingWorld;
    private int customerSpawnRate, customerDir;
    //variables for spawning customers
    private int dir, startingY, dirRNG;
    private ArrayList<GreenfootSound> pausedSounds;
    
    private boolean cash2Mama = false, cash2Papa = false;
    
    Utils utils = new Utils();
    
    CashierCover coverRight = new CashierCover("right");
    CashierCover coverLeft = new CashierCover("left");
    OvenCover cover1 = new OvenCover();
    OvenCover cover2 = new OvenCover();
    OvenCover cover3 = new OvenCover();
    OvenCover cover4 = new OvenCover();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(SettingWorld settingWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        addObject(utils, 0, 0);
        this.settingWorld = settingWorld;
        isSimOver = false;
        pausedSounds = new ArrayList<GreenfootSound>();
        //adds oven objects left
        addObject(new Oven(), Utils.oven1X, Utils.ovenY);
        addObject(new Oven(), Utils.oven2X, Utils.ovenY);
        addObject(new Oven(), Utils.oven3X, Utils.ovenY);
        addObject(cover1, Utils.oven2X - 1, Utils.ovenY);
        addObject(cover2, Utils.oven3X + 5, Utils.ovenY);
        //adds oven objects right
        addObject(new Oven(), Utils.oven4X, Utils.ovenY);
        addObject(new Oven(), Utils.oven5X, Utils.ovenY);
        addObject(new Oven(), Utils.oven6X, Utils.ovenY);
        addObject(cover3, Utils.oven5X + 5, Utils.ovenY);
        addObject(cover4, Utils.oven6X - 5, Utils.ovenY);
        
        //adds chef objects left
        addObject(new Chef(Utils.chef1Y, 100, 100, -1), Utils.chefXLeft, Utils.chef1Y);
        if (settingWorld.getChefNumMama() == 2){
            addObject(new Chef(Utils.chef2Y, 100, 100, -1), Utils.chefXLeft, Utils.chef2Y);
        }
        if (settingWorld.getChefNumMama() == 3){
            addObject(new Chef(Utils.chef2Y, 100, 100, -1), Utils.chefXLeft, Utils.chef2Y);
            addObject(new Chef(Utils.chef3Y, 100, 100, -1), Utils.chefXLeft, Utils.chef3Y);
        }
        
        //adds chef objects right
        addObject(new Chef(Utils.chef1Y, 100, 100, 1), Utils.chefXRight, Utils.chef1Y);
        if (settingWorld.getChefNumPapa() == 2){
            addObject(new Chef(Utils.chef2Y, 100, 100, 1), Utils.chefXRight, Utils.chef2Y);
        }
        if (settingWorld.getChefNumPapa() == 3){
            addObject(new Chef(Utils.chef2Y, 100, 100, 1), Utils.chefXRight, Utils.chef2Y);
            addObject(new Chef(Utils.chef3Y, 100, 100, 1), Utils.chefXRight, Utils.chef3Y);
        }
    
        //adds cashier objects left
        addObject(new Cashier(Utils.cashier1X, Utils.cashierY, 100, 100, -1), Utils.cashier1X, 460);
        addObject(coverLeft, 408, 504);
        if (settingWorld.getCashierNumMama() == 2){
            addObject(new Cashier(Utils.cashier2X, Utils.cashierY, 100, 100, -1), Utils.cashier2X, 460);
            removeObject(coverLeft);
            cash2Mama = true;
        }
        
        //adds cashier objects right
        addObject(new Cashier(Utils.cashier4X, Utils.cashierY, 100, 100, 1), Utils.cashier4X, 460);
        addObject(coverRight, 617, 507);
        if (settingWorld.getCashierNumPapa() == 2){
            addObject(new Cashier(Utils.cashier3X, Utils.cashierY, 100, 100, 1), Utils.cashier3X, 460);
            removeObject(coverRight);
            cash2Papa = true;
        }
        //adds kitchen counters left
        addObject(new KitchenCounter(-1), Utils.kitchenCounterXLeft, Utils.kitchenCounterY1);
        addObject(new KitchenCounter(-1), Utils.kitchenCounterXLeft, Utils.kitchenCounterY2);
        addObject(new KitchenCounter(-1), Utils.kitchenCounterXLeft, Utils.kitchenCounterY3);
        //adds kitchen counters right
        addObject(new KitchenCounter(1), Utils.kitchenCounterXRight, Utils.kitchenCounterY1);
        addObject(new KitchenCounter(1), Utils.kitchenCounterXRight, Utils.kitchenCounterY2);
        addObject(new KitchenCounter(1), Utils.kitchenCounterXRight, Utils.kitchenCounterY3);
        //adds doors left
        addObject(new Door(), Utils.door1X, Utils.enterY);
        addObject(new Door(), Utils.door1X, Utils.exitY);
        //adds doors right
        addObject(new Door(), Utils.door2X, Utils.enterY);
        addObject(new Door(), Utils.door2X, Utils.exitY);
        //adds cashier counters left
        addObject(new CashierCounter(), Utils.cashier1X, Utils.counterY);
        addObject(new CashierCounter(), Utils.cashier2X, Utils.counterY);
        //adds cashier counters right
        addObject(new CashierCounter(), Utils.cashier3X, Utils.counterY);
        addObject(new CashierCounter(), Utils.cashier4X, Utils.counterY);
        //adds waiting locations left
        addObject(new WaitingLine(), Utils.wait1X, Utils.counterY);
        addObject(new WaitingLine(), Utils.wait2X, Utils.counterY);
        addObject(new WaitingLine(), Utils.wait3X, Utils.counterY);
        //adds waiting locations right
        addObject(new WaitingLine(), Utils.wait4X, Utils.counterY);
        addObject(new WaitingLine(), Utils.wait5X, Utils.counterY);
        addObject(new WaitingLine(), Utils.wait6X, Utils.counterY);
        
        
    }
    
    public void act() {
        spawnCustomer();
        checkLevel();
    }
    
    public void checkLevel()
    {
        if(utils.getResturantLevelOne() == 2 && !changedLevelTwoLeft)
        {
            changedLevelTwoLeft = true;
            removeObject(cover1);
            
            if (settingWorld.getCashierNumMama() == 1)
            {
                addObject(new Cashier(Utils.cashier2X, Utils.cashierY, 100, 100, -1), Utils.cashier2X, 460);
                removeObject(coverLeft);
                cash2Mama = true;
            }
            
            if(settingWorld.getChefNumMama() == 1)
            {
                addObject(new Chef(Utils.chef2Y, 100, 100, -1), Utils.chefXLeft, Utils.chef2Y);
            }
            if(settingWorld.getChefNumMama() == 2)
            {
                addObject(new Chef(Utils.chef3Y, 100, 100, -1), Utils.chefXLeft, Utils.chef3Y);
            }
            
        }
        if(utils.getResturantLevelOne() == 3 && !changedLevelThreeLeft)
        {
            changedLevelThreeLeft = true;
            removeObject(cover2);
            
            if(settingWorld.getChefNumMama() == 1)
            {
                addObject(new Chef(Utils.chef3Y, 100, 100, -1), Utils.chefXLeft, Utils.chef3Y);
            }
        }
        
        if(utils.getResturantLevelTwo() == 2 && !changedLevelTwoRight)
        {
            changedLevelTwoRight = true;
            removeObject(cover3);
            
            if (settingWorld.getCashierNumPapa() == 1)
            {
                addObject(new Cashier(Utils.cashier3X, Utils.cashierY, 100, 100, 1), Utils.cashier3X, 460);
                removeObject(coverRight);
                cash2Papa = true;
            }
            
            if(settingWorld.getChefNumPapa() == 1)
            {
                addObject(new Chef(Utils.chef2Y, 100, 100, 1), Utils.chefXRight, Utils.chef2Y);
            }
            if(settingWorld.getChefNumPapa() == 2)
            {
                addObject(new Chef(Utils.chef3Y, 100, 100, 1), Utils.chefXRight, Utils.chef3Y);
            }
        }
        if(utils.getResturantLevelTwo() == 3 && !changedLevelThreeRight)
        {
            changedLevelThreeRight = true;
            removeObject(cover4);
            
            if(settingWorld.getChefNumMama() == 1)
            {
                addObject(new Chef(Utils.chef3Y, 100, 100, 1), Utils.chefXRight, Utils.chef3Y);
            }
        }
    }
    
    public void changeLevel()
    {
        utils.addResturantLevelOne();
        utils.addResturantLevelTwo();
    }
    
    public void spawnCustomer()
    {
        dirRNG = Greenfoot.getRandomNumber(2);
        
        if(dirRNG == 1)
        {
            dir = 1;
            startingY = 81;
        }
        else if(dirRNG == 0)
        {
            dir = -1;
            startingY = getHeight();
        }
        
        int rng = Greenfoot.getRandomNumber(120);
        int customerSpawnX = Greenfoot.getRandomNumber(80) + 470;
        
        if(rng == 0)
        {
            addObject(new Customer(dir, customerSpawnX, cash2Mama, cash2Papa), customerSpawnX, startingY);
        }
    }
    
    public void removeAllActors() {
        ArrayList<Actor> actors = (ArrayList) getObjects(null);
        for(Actor actor : actors) {
           removeObject(actor); 
        }
    }
    
    public boolean checkSimOver() {
        return this.isSimOver;
    }
    
    public void setUpNewSim() {
        
    }
    
    public void stopped() {
        // stop all sounds
        pausedSounds.clear();
        ArrayList<ISoundCentre> sounds = (ArrayList<ISoundCentre>) getObjects(ISoundCentre.class);
        for (ISoundCentre sound : sounds) {
            int index = sound.getSoundNumber();
            if (sound.isSoundPlaying(index)) {
                sound.pauseSound(index);
                pausedSounds.add(sound.getSound(index));
            }
        }
        // stop background sound
        BackgroundSound.getInstance().pauseSound();
    }
    
    public void started() {
        // play all sounds
        ArrayList<ISoundCentre> sounds = (ArrayList<ISoundCentre>) getObjects(ISoundCentre.class);
        for (ISoundCentre sound : sounds) {
            if (pausedSounds.contains(sound)) {
                sound.playSound(sound.getSoundNumber());
            }
        }
        // play background sound in loop
        BackgroundSound.getInstance().playSound();
    }
}
