import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer extends People
{
    private int spawnX, dir, storeRNG, store, toppingRNG, cheeseRNG, sauceRNG;
    
    private boolean inStore, ordered, atLineUp, pickedUp, waiting, cheese;
    
    private String[] toppings = new String[3];
    private String sauce, topping;
    private int costOfPizza = 5;
    
    private int openCash, openWait;
    
    private CashierCounter cash1, cash2;
    private WaitingLine wait1, wait2, wait3;
    private boolean chef1, chef2;
    private Cashier cashier;
    private Pizza pizza1, pizza2, pizza3;
    
    private int imageRNG, rotation;
    private String gender;
    private GreenfootImage upIMG, downIMG, leftIMG, rightIMG;
    
    GreenfootImage[] walkUp = new GreenfootImage[9];
    GreenfootImage[] walkDown = new GreenfootImage[9];
    GreenfootImage[] walkLeft = new GreenfootImage[9];
    GreenfootImage[] walkRight = new GreenfootImage[9];
    
    private int imageIndex = 0;
    
    private SimpleTimer animTimer = new SimpleTimer();
    private SimpleTimer waitTimer = new SimpleTimer();
    
    private boolean checkedLocations = false;
    
    private int enterDIR, exitDIR;
    
    public Customer (int dir, int spawnX) {
        this.dir = dir;
        this.spawnX = spawnX;
        
        //sets starting frame based on direction
        if (dir == -1){
            rotation = UP;
        } else {
            rotation = DOWN;
        }
        
        //randomizes which store and gender they are
        storeRNG = Greenfoot.getRandomNumber(2);
        imageRNG = Greenfoot.getRandomNumber(2);
        
        if (storeRNG == 0){
            store = -1;
            enterDIR = LEFT;
            exitDIR = RIGHT;
        } else {
            store = 1;
            enterDIR = RIGHT;
            exitDIR = LEFT;
        }
        
        if (imageRNG == 0){
            gender = "boy";
        } else {
            gender = "girl";
        }
        //sets stationary images and scales them up
        upIMG = new GreenfootImage(gender + "_U.png");
        upIMG.scale((int)(upIMG.getWidth() * 1.5), (int)(upIMG.getHeight() * 1.5));
        downIMG = new GreenfootImage(gender + "_D.png");
        downIMG.scale((int)(downIMG.getWidth() * 1.5), (int)(downIMG.getHeight() * 1.5));
        leftIMG = new GreenfootImage(gender + "_L.png");
        leftIMG.scale((int)(leftIMG.getWidth() * 1.5), (int)(leftIMG.getHeight() * 1.5));
        rightIMG = new GreenfootImage(gender + "_R.png");
        rightIMG.scale((int)(rightIMG.getWidth() * 1.5), (int)(rightIMG.getHeight() * 1.5));
        
        //sets animation images and scales them up
        for(int i = 0; i < 9; i++){
            walkUp[i] = new GreenfootImage("images/" + gender + "_Animations/Up/" + (i + 1) + ".png");
            walkUp[i].scale((int)(walkUp[i].getWidth() * 1.5), (int)(walkUp[i].getHeight() * 1.5));
            walkDown[i] = new GreenfootImage("images/" + gender + "_Animations/Down/" + (i + 1) + ".png");
            walkDown[i].scale((int)(walkDown[i].getWidth() * 1.5), (int)(walkDown[i].getHeight() * 1.5));
            walkLeft[i] = new GreenfootImage("images/" + gender + "_Animations/Left/" + (i + 1) + ".png");
            walkLeft[i].scale((int)(walkLeft[i].getWidth() * 1.5), (int)(walkLeft[i].getHeight() * 1.5));
            walkRight[i] = new GreenfootImage("images/" + gender + "_Animations/Right/" + (i + 1) + ".png");
            walkRight[i].scale((int)(walkRight[i].getWidth() * 1.5), (int)(walkRight[i].getHeight() * 1.5));
        }
        
        //randomizes toppings 
        for(int i = 0; i < toppings.length; i++)
        {
            toppingRNG = Greenfoot.getRandomNumber(4);
            switch (toppingRNG){
            case 0:
                topping = "pepperoni";
                costOfPizza += 1;
                break;
            case 1:
                topping = "peppers";
                costOfPizza += 2;
                break;
            case 2:
                topping = "ham";
                costOfPizza += 3;
                break;
            case 3:
                topping = "olives";
                costOfPizza += 2;
            }
            toppings[i] = topping;
        }
        
        //randomizes if customer wants cheese or not
        cheeseRNG = Greenfoot.getRandomNumber(2);
        if (cheeseRNG == 0){
            cheese = true;
            costOfPizza += 2;
        } else {
            cheese = false;
        }
        
        //randomizes sauce 
        sauceRNG = Greenfoot.getRandomNumber(2);
        if (sauceRNG == 0){
            sauce = "tomato";
            costOfPizza += 1;
        } else {
            sauce = "bbq";
            costOfPizza += 2;
        }
    }
    
    public void act (){
        //set locations for cashiers and waitingline
        if(!checkedLocations){
            cash1 = getWorld().getObjectsAt(Utils.cashier1X, Utils.counterY, CashierCounter.class).get(0);
            cash2 = getWorld().getObjectsAt(Utils.cashier2X, Utils.counterY, CashierCounter.class).get(0);
        
            wait1 = getWorld().getObjectsAt(Utils.wait1X, Utils.counterY, WaitingLine.class).get(0);
            wait2 = getWorld().getObjectsAt(Utils.wait2X, Utils.counterY, WaitingLine.class).get(0);
            wait3 = getWorld().getObjectsAt(Utils.wait3X, Utils.counterY, WaitingLine.class).get(0);
            
            checkedLocations = true;
        }
        
        //does not animate if customer is standing still
        if(waiting){
            stationary();
        } else {
            animation();
        }
        
        //moves towards door if havent bought pizza yet, else walks away with pizza
        //also ignores doors if there are more than 5 customers
        if (!inStore) {
            if (numberOfCustomers1 >= 5){
                setLocation(getX(), getY() + (Utils.moveSpeed * dir));
                
                if (dir == 1){
                    rotation = DOWN;
                } else if (dir == -1){
                    rotation = UP;
                }
            } else if(ordered && pickedUp){
                if (getX() == spawnX){
                    setLocation(getX(), getY() + (Utils.moveSpeed * dir));
                
                    if (dir == 1){
                        rotation = DOWN;
                    } else if (dir == -1){
                        rotation = UP;
                    }
                } else {
                    setLocation(getX() + Utils.moveSpeed, getY());
                }
            } else {    
                moveToDoor();
            }
        }
        
        //moves to cashier, orders, line up, pickup pizza, leave
        if (inStore){
            if (!ordered && !pickedUp){
                moveToCashier();
            } else if (ordered){
                if (!pickedUp){
                    if (!atLineUp){
                        lineUp();
                    } else {
                        pizzaPickup();
                    }
                } else {
                    leave();
                }
            }
        }
        
        //removes actor when at edge
        atEdge();
    }
    
    //stationary images based on rotation
    public void stationary(){
        switch (rotation){
            case UP:
                setImage(upIMG);
                break;
            case DOWN:
                setImage(downIMG);
                break;
            case LEFT:
                setImage(leftIMG);
                break;
            case RIGHT:
                setImage(rightIMG);
                break;
        }
    }
    
    //animations based on rotation
    public void animation(){
        if(imageIndex == 6){
            imageIndex = 0;
        }
        
        switch (rotation){
            case UP:
                if (animTimer.millisElapsed() > 100){
                    setImage(walkUp[imageIndex]);
                    imageIndex++;
                    
                    animTimer.mark();
                }
                break;
            case DOWN:
                if (animTimer.millisElapsed() > 100){
                    setImage(walkDown[imageIndex]);
                    imageIndex++;
                    
                    animTimer.mark();
                }
                break;
            case LEFT:
                if (animTimer.millisElapsed() > 100){
                    setImage(walkLeft[imageIndex]);
                    imageIndex++;
                    
                    animTimer.mark();
                }
                break;
            case RIGHT:
                if (animTimer.millisElapsed() > 100){
                    setImage(walkRight[imageIndex]);
                    imageIndex++;
                    
                    animTimer.mark();
                }
                break;
        }
    }
    
    public int getRotation(){
        return rotation;
    }
    
    public void moveToDoor(){
        //moves towards the door if its in range
        if(this.getObjectsInRange(100, Door.class).size() > 0){
            if (store == -1){
                rotation = LEFT;
            } else {
                rotation = RIGHT;
            }
            
            if(getX() > Utils.door1X && getX() < Utils.door2X){
                setLocation(getX() + (Utils.moveSpeed * store), getY());
            }
            
            if(getY() != Utils.enterY){
                setLocation(getX(), getY() + (Utils.moveSpeed * dir));
            }
            
        } else {
            //keeps moving until it detects a door
            setLocation(getX(), getY() + (Utils.moveSpeed * dir));
        }
        
        //checks if they enter the door
        if(getX() <= Utils.door1X && getY() == Utils.enterY){
            inStore = true;
            //customer counter for each store, static variable in persons class
            if(store == -1){
                addCustomer1();
            } else {
                addCustomer2();
            }
            
            //starts a happiness meter
            waitTimer.mark();
            getWorld().addObject(new WaittingBar(this), getX(), getY() + 10);
            
            //reserves a cashier
            if (cash1.checkIfEmpty() && !cash1.isReserved()){
                openCash = 1;
                cash1.reserve(true);
            } else if (cash2.checkIfEmpty() && !cash2.isReserved()){
                openCash = 2;
                cash2.reserve(true);
            }
        }
    }
    
    public void moveToCashier (){
        if (rotation == LEFT){
            if (openCash == 1){
                
                if(getX() != Utils.cashier1X){
                    setLocation(getX() + (Utils.moveSpeed * store), getY());
                } else {
                    rotation = UP;
                }
            } else if (openCash == 2){
                
                if(getX() != Utils.cashier2X){
                    setLocation(getX() + (Utils.moveSpeed * store), getY());
                } else {
                    rotation = UP;
                }
            }
        }
        
        if (rotation == UP){
            if (getY() != Utils.counterY){
                setLocation(getX(), getY() - 1);
            } else {
                cashier = (Cashier) getOneObjectAtOffset(0, Utils.cashierY - Utils.counterY, Cashier.class);
                chef1 = getWorld().getObjectsAt(Utils.chefX, Utils.chef1Y, Chef.class).isEmpty();
                chef2 = getWorld().getObjectsAt(Utils.chefX, Utils.chef1Y, Chef.class).isEmpty();
                
                waiting = true;
                
                order(cashier, chef1, chef2);
            }
        }
    }
    
    public void order (Cashier cashier, boolean chef1, boolean chef2){
        //only orders if there is a cashier infront of them and a chef at the table
        if ((cashier != null && cashier.atStart()) && (!chef1 || !chef2)){
            getWorld().addObject(new Order(sauce, cheese, toppings, this), getX() + 20, getY() - (getImage().getHeight() / 2) - 20);
            
            /**MONEY INTERFACE
             * getWorld().addObject(new MoneyInterface(costOfPizza), x, y);
            **/
            
            ordered = true;
            waiting = false;
            
            //reserves a waiting line
            if (wait1.checkIfEmpty() && !wait1.isReserved()){
                openWait = 1;
                wait1.reserve(true);
            } else if (wait2.checkIfEmpty() && !wait2.isReserved()){
                openWait = 2;
                wait2.reserve(true);
            } else if (wait3.checkIfEmpty() && !wait3.isReserved()){
                openWait = 3;
                wait3.reserve(true);
            }
        }
    }
    
    public void lineUp(){
        if (rotation == UP){
            if (getX() == Utils.cashier1X) {
                rotation = DOWN;
                cash1.reserve(false);
            } else if (getX() == Utils.cashier2X){
                rotation = DOWN;
                cash2.reserve(false);
            } else {
                if (getY() != Utils.counterY){
                    setLocation(getX(), getY() - 1);
                } else {
                    waiting = true;
                    atLineUp = true;
                }
            }
        }
        
        if (rotation == DOWN){
            setLocation(getX(), getY() + 1);
            
            if (getY() == Utils.enterY){
                rotation = LEFT;
            }
        }
        
        if (rotation == LEFT){
            if (openWait == 1){
                if(getX() != Utils.wait1X){
                    setLocation(getX() + (Utils.moveSpeed * store), getY());
                } else {
                    rotation = UP;
                }
            } else if (openWait == 2){
                if(getX() != Utils.wait2X){
                    setLocation(getX() + (Utils.moveSpeed * store), getY());
                } else {
                    rotation = UP;
                }
            } else if (openWait == 3){
                if(getX() != Utils.wait3X){
                    setLocation(getX() + (Utils.moveSpeed * store), getY());
                } else {
                    rotation = UP;
                }
            } 
        }
    }
    
    public void pizzaPickup() {
        //checks all 3 possible locations of pizza, based on current location
        if (getX() == Utils.wait1X){
            pizza1 = (Pizza) getOneObjectAtOffset(0, Utils.pizzaFinalY - Utils.counterY, Pizza.class);
            pizza2 = (Pizza) getOneObjectAtOffset(Utils.wait2X - getX(), Utils.pizzaFinalY - Utils.counterY, Pizza.class);
            pizza3 = (Pizza) getOneObjectAtOffset(Utils.wait3X - getX(), Utils.pizzaFinalY - Utils.counterY, Pizza.class);
        } else if (getX() == Utils.wait2X){
            pizza1 = (Pizza) getOneObjectAtOffset(Utils.wait1X - getX(), Utils.pizzaFinalY - Utils.counterY, Pizza.class);
            pizza2 = (Pizza) getOneObjectAtOffset(0, Utils.pizzaFinalY - Utils.counterY, Pizza.class);
            pizza3 = (Pizza) getOneObjectAtOffset(Utils.wait3X - getX(), Utils.pizzaFinalY - Utils.counterY, Pizza.class);
        } else if (getX() == Utils.wait3X){
            pizza1 = (Pizza) getOneObjectAtOffset(Utils.wait1X - getX(), Utils.pizzaFinalY - Utils.counterY, Pizza.class);
            pizza2 = (Pizza) getOneObjectAtOffset(Utils.wait2X - getX(), Utils.pizzaFinalY - Utils.counterY, Pizza.class);
            pizza3 = (Pizza) getOneObjectAtOffset(0, Utils.pizzaFinalY - Utils.counterY, Pizza.class);
        }
        
        //only picks up the one that matches the order
        if (pizza1 != null && pizza1.getY() == Utils.pizzaFinalY){
            if (pizza1.getToppings() == toppings && pizza1.getSauce() == sauce){
                pizza1.setCPU(this);
                pickedUp = true;
            }
        }
        if (pizza2 != null && pizza2.getY() == Utils.pizzaFinalY){
            if (pizza2.getToppings() == toppings && pizza2.getSauce() == sauce){
                pizza2.setCPU(this);
                pickedUp = true;
            }
        }
        if (pizza3 != null && pizza3.getY() == Utils.pizzaFinalY){
            if (pizza3.getToppings() == toppings && pizza3.getSauce() == sauce){
                pizza3.setCPU(this);
                pickedUp = true;
            }
        }
    }
    
    public void leave(){
        if (rotation == UP){
            rotation = DOWN;
            
            if (getX() == Utils.wait1X){
                wait1.reserve(false);
            } else if (getX() == Utils.wait2X){
                wait2.reserve(false);
            } else {
                wait3.reserve(false);
            }
            
            waiting = false;
            atLineUp = false;
        }
        
        if (rotation == DOWN){
            if (getY() != Utils.exitY){
                setLocation(getX(), getY() + 1);
            } else {
                rotation = RIGHT;
            }
        }
        
        if (rotation == RIGHT){
            if (getX() != Utils.door1X){
                setLocation(getX() + 1, getY());
            }
        }
        
        if (getX() == Utils.door1X && getY() == Utils.exitY){
            inStore = false;
            
            //removes a customer from the counter
            if(store == -1){
                removeCustomer1();
            } else {
                removeCustomer2();
            }
        }
    }
    
    public void atEdge(){
        if (dir == 1 && getY() == 799){
            getWorld().removeObject(this);
        } else if (dir == -1 && getY() == 81){
            getWorld().removeObject(this);
        }
    }
    
    public boolean getPickedUp(){
        return pickedUp;
    }
    
    public boolean getInStore(){
        return inStore;
    }
    
    public int getWaitTime(){
        return waitTimer.millisElapsed();
    }
}
