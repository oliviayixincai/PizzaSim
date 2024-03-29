import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * <h1>The Pizza Simulation finished by Group 1.</h1>
 * <p> Group member: Yixin Cai, Anson Ho, Yuxin Li, Gloria Chan, Andy Li, Eric Zheng</p>
 * 
 * <h2>Major Interactions</h2>
 * 
 * <h3>People Superclass</h3>
 * <p> All people subclasses interface with Utils class to determine locations coordinates. Superclass abstracts animation for all subclasses.
 * 
 * <p>Chef Main Interactions
 *   <ul>
 *     <p>Pizza 
 *     <li>Chef checks pizza methods to make sure that pizza is fully made and can be moved</li>
 *     <p>Oven
 *     <li>Chef checks oven methods to make sure that a pizza can be moved to that oven</li>
 *     <li>Chef checks oven methods to reserve oven to make sure only 1 chef can put a pizza in at a time</li>
 *   </ul>
 *      
 * <p>Cashier Main Interactions
 *   <ul>
 *     <p>Oven
 *     <li>Checks oven methods to check if pizza is cooked and can be picked up</li>
 *     <p>Customer
 *     <li>When a cashier is at a cashier till, it allows a customer to place their order. Customer accesses methods in cashier</li>
 *   </ul>    
 *     
 * <p>Customer Main Interactions
 *   <ul>
 *     <p>Door 
 *     <li>Checks for doors as they walk down the middle path, ignores doors if there are a lot of customers already in the store</li>
 *     <p>CashierCounter
 *     <li>Checks and moves towards an empty counter, waits at the door if both cashiers are occupied</li>
 *     <p>WaitingBar
 *     <li>Once arrived at the counter, the patience bar appears and displays their current mood, it lowers as their wait time increases</li>
 *     <p>Order
 *     <li>When there is a cashier in front of them and an available chef, the customer will randomize and place an order</li>
 *     <p>MoneyInterface
 *     <li>After they place an order, the cost of the pizza is added to the store income, indicated by a sound then moves to an empty counter to wait</li>
 *     <p>Pizza
 *     <li>Checks and picks up the pizza that corresponds to their order, then leaves the store</li>
 *   </ul>
 * 
 * <p>Robber Interactions
 *   <ul>
 *     <p>MoneyInterface
 *     <li>“Steals” a set amount of money from the store.</li>
 *   </ul>
 *   
 * <h3>Level Superclass</h3>
 * <p> Constantly checks the money value of both stores to change level variables. MyWorld constantly checks level variable and changes functionality of game accordingly
 * 
 * <p>Main Interactions
 *   <ul>
 *     <p>Utils
 *     <li>Changes the utils value of level for each store depending on conditional statements based on money value</li>
 *   </ul>
 *   
 * <h3>Effect Superclass</h3>
 * <p> Creates in game effects that make the game look more visually appealing and clear
 * 
 * <p>Clock Functionality
 *   <ul>
 *     <p>Is initialized if the pizza is sent to an oven. Display a sequence of countdown images to show the time left for pizza to be cooked. If the time runs out, the clock will shake and alarm. 
 *   </ul>
 *   
 * <p>WaitingBar Functionality
 *   <ul>
 *     <p>The current happiness for the Customer. Each segment has its own unique gif with a total of 6 segments. A sound is played to indicate when a customer has reached the lowest mood. Once they pick up their pizza, tips are paid based on the current mood and a sound is played.  
 *   </ul>
 *   
 * <p>Order Functionality
 *   <ul>
 *     <p>Spawned after a customer orders. Visually displays the customer’s order by drawing out the order above the customer, and initializes a pizza.
 *   </ul>
 *   
 * <h2>Known Bugs</h2>
 * <ul>
 *     <li>Volume label does not match setting world after worlds change</li>
 *     <li>Customer leave move method sometimes does not follow specified path. Unknown reason due to rarity</li>
 * </ul>
 *
 * <h2>Credit:</h2>
 * 
 * <p>
 * Background music:
 * Run Amok by Kevin MacLeod | https://incompetech.com/
 * Music promoted by https://www.chosic.com/free-music/all/
 * Creative Commons CC BY 3.0
 * https://creativecommons.org/licenses/by/3.0/
 * </p>
 * <p>
 * Click music:
 * Sound Effect by <a href="https://pixabay.com/users/sennafoxy-177
 * 62344/?utm_source=link-attribution&amp;utm_medium=referral&amp;ut
 * m_campaign=music&amp;utm_content=14388">SennaFoxy</a> from <a href
 * ="https://pixabay.com//?utm_source=link-attribution&amp;utm_medium=
 * referral&amp;utm_campaign=music&amp;utm_content=14388">Pixabay</a>
 * </p>
 * <p>Angry hmp sound clips: Sound Effect from <a href="https://pixabay.com/
 * sound-effects/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm
 * _campaign=music&amp;utm_content=38556">Pixabay</a>
 * </p>
 * <p>Clock tik sound clip: Sound Effect from <a href="https://pixabay.com/sound
 * -effects/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign
 * =music&amp;utm_content=55420">Pixabay</a>
 * </p>
 * <p>Other Sound clips: https://pixabay.com/music/</p>
 * 
 * <p>"Aloe Vera Plants" from Pinterest (https://www.pinterest.ca/pin/all-6-plants-pattern-aloe-vera-potted-plant-succulent-ivy-etsy-in-2022--88172105197560932/).</p> 
 * <p>"Animal Crossing Stepping Stones" by Rose from Pinterest (https://www.pinterest.ca/pin/538672805434277806/).</p>
 * <p>"16x16 Fence and Well" by William.Thompsonj from OpenGameArt (https://opengameart.org/content/16x16-fence-and-well-tiny-16).</p>
 * <p>“Pixel Art of Book Shelf Stack” from FreePik (https://www.freepik.com/premium-vector/pixel-art-book-shelf-stack_16557038.htm).</p>
 * 
 * Credits for the Chef and Customers are in the folder "credits".
 * 
 * @author Group1 - Yixin Cai, Anson Ho, Yuxin Li, Gloria Chan, Andy Li, Eric Zheng
 * @version November 2022
 */
public class MyWorld extends World
{
    private boolean isSimOver, changedLevelTwoLeft, changedLevelTwoRight, changedLevelThreeLeft, changedLevelThreeRight;
    private SettingWorld settingWorld;
    private int customerSpawnRate, customerDir, previousMoneyMama = 0, previousMoneyPapa = 0;
    //variables for spawning customers
    private Label volumeLabel;
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
        addObject(new MoneyInterface(utils), 0, 0);
        addObject(new LevelUp(), 0, 0);
        this.settingWorld = settingWorld;
        
        utils.setRobbingMoneyMama(settingWorld.getRobberStealMama() * -1);
        utils.setRobbingMoneyPapa(settingWorld.getRobberStealPapa() * -1);
        
        isSimOver = false;
        pausedSounds = new ArrayList<GreenfootSound>();
        // add volume control
        volumeLabel = new Label(Utils.volume + "%");
        addObject(new VolumeButton(false), 450, 40);
        addObject(new VolumeButton(true), 575, 40);
        addObject(volumeLabel, 512, 40);
        //adds oven objects left
        addObject(new Oven(), Utils.oven1X, Utils.ovenY);
        addObject(new Oven(), Utils.oven2X, Utils.ovenY);
        addObject(new Oven(), Utils.oven3X, Utils.ovenY);
        addObject(cover1, Utils.oven2X - 1, Utils.ovenY);
        addObject(cover2, Utils.oven3X + 5, Utils.ovenY);
        if(settingWorld.getOvenNumMama() == 2)
        {
            removeObject(cover1);
        }
        if(settingWorld.getOvenNumMama() == 3)
        {
            removeObject(cover1);
            removeObject(cover2);
        }
        //adds oven objects right
        addObject(new Oven(), Utils.oven4X, Utils.ovenY);
        addObject(new Oven(), Utils.oven5X, Utils.ovenY);
        addObject(new Oven(), Utils.oven6X, Utils.ovenY);
        addObject(cover3, Utils.oven5X + 5, Utils.ovenY);
        addObject(cover4, Utils.oven6X - 5, Utils.ovenY);
        if(settingWorld.getOvenNumPapa() == 2)
        {
            removeObject(cover3);
        }
        if(settingWorld.getOvenNumPapa() == 3)
        {
            removeObject(cover3);
            removeObject(cover4);
        }
        
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
        //addObject
        addObject(new MoneyDisplayer(this.settingWorld.getMoneyNumMama()), 213, 25);
        addObject(new MoneyDisplayer(this.settingWorld.getMoneyNumPapa()), 795, 25);
        
        addObject(new LevelDisplayer(1), 213, 50);
        addObject(new LevelDisplayer(1), 795, 50);
        
        utils.resturantMoneyOneAdd(settingWorld.getMoneyNumMama());
        utils.resturantMoneyTwoAdd(settingWorld.getMoneyNumPapa());
        
        if(utils.getResturantMoneyOne() > 200)
        {
            utils.addResturantLevelOne();
            utils.addResturantLevelOne();
        }
        if(utils.getResturantMoneyTwo() > 200)
        {
            utils.addResturantLevelTwo();
            utils.addResturantLevelTwo();
        }
        
    }
    
    public void act() {
        spawnCustomer();
        checkLevel();
        spawnRobber();
    }
    
    /**
     * Checks leveling system to unlock items in the world
     */
    public void checkLevel()
    {
        //changes level for left store
        if((utils.getResturantLevelOne() == 2 || utils.getResturantMoneyOne() > 100) && !changedLevelTwoLeft)
        {
            changedLevelTwoLeft = true;
            
            if(settingWorld.getOvenNumMama() == 1)
            {
                removeObject(cover1);
            }
            if(settingWorld.getOvenNumMama() == 2)
            {
                removeObject(cover2);
            }
            
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
            
            if(settingWorld.getChefNumMama() == 1)
            {
                addObject(new Chef(Utils.chef3Y, 100, 100, -1), Utils.chefXLeft, Utils.chef3Y);
            }
            if(settingWorld.getOvenNumMama() == 1)
            {
                removeObject(cover2);
            }
        }
        //changes level for right store
        if((utils.getResturantLevelTwo() == 2 || utils.getResturantMoneyTwo() > 100) && !changedLevelTwoRight)
        {
            changedLevelTwoRight = true;
            if(settingWorld.getOvenNumPapa() == 1)
            {
                removeObject(cover3);
            }
            if(settingWorld.getOvenNumPapa() == 2)
            {
                removeObject(cover4);
            }
            
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
            
            if(settingWorld.getChefNumPapa() == 1)
            {
                addObject(new Chef(Utils.chef3Y, 100, 100, 1), Utils.chefXRight, Utils.chef3Y);
            }
            if(settingWorld.getOvenNumPapa() == 1)
            {
                removeObject(cover4);
            }
        }
    }
    
    /**
     * Method to spawn customer based on random number gen
     */
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
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * sound will be store in an arry if it currently playing.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        // stop all sounds
        pausedSounds.clear();
        ArrayList<ISound> sounds = (ArrayList<ISound>) getObjects(ISound.class);
        for (ISound sound : sounds) {
            if (sound.isSoundPlaying()) {
                sound.pauseSound();
                pausedSounds.add(sound.getSound());
            }
        }
        // stop background sound
        Utils.backgroundSound.pause();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Only paused sound will be played once program is started.
     * Background sound will continously play in loop.
     */
    public void started() {
        // play all sounds
        ArrayList<ISound> sounds = (ArrayList<ISound>) getObjects(ISound.class);
        for (ISound sound : sounds) {
            if (pausedSounds.contains(sound)) {
                sound.playSound();
            }
        }
        // play background sound in loop
        Utils.backgroundSound.playLoop();
    }
    
    /**
     * Method to stop all of the sounds
     */
    public void stopSounds() {
        ArrayList<ISound> sounds = (ArrayList<ISound>) getObjects(ISound.class);
        for (ISound sound : sounds) {
            sound.pauseSound();
        }
    }
    
    /**
     * Update volume.
     * @param isUp True if turn volume up, Flase otherwise.
     */
    public void updateVolume(boolean isUp) {
        if(isUp) {
            Utils.volume = Math.min(Utils.volume + 20, 100);
        }
        else {
            Utils.volume = Math.max(Utils.volume - 20, 0);
        }
        ArrayList<ISound> sounds = (ArrayList<ISound>) getObjects(ISound.class);
        for (ISound sound : sounds) {
            sound.setVolume(Utils.volume);
        }
        //  Update background sound volume.
        Utils.backgroundSound.setVolume(Utils.volume);
        // Update volume label.
        volumeLabel.updateLabel(Utils.volume + "%");
    }

    /**
     * Method to spawn robber based on money of resturants
     */
    public void spawnRobber()
    {
        if(utils.getResturantMoneyOne() - previousMoneyMama > 50)
        {
            previousMoneyMama = utils.getResturantMoneyOne();
            addObject(new Robber(1), 512, 100);
        }
        if(utils.getResturantMoneyTwo() - previousMoneyPapa > 50)
        {
            previousMoneyPapa = utils.getResturantMoneyTwo();
            addObject(new Robber(-1), 512, 100);
        }
    }
}