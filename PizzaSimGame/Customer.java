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
    private int dir, storeRNG, store;  
    
    private boolean cash1IsFree, cash2IsFree, atCounter, inStore, atDoor;
    
    private List<Customer> c1, c2;
    
    public Customer (int dir) {
        this.dir = dir;
        
        atCounter = false;
        atDoor = false;
        
        storeRNG = Greenfoot.getRandomNumber(2);
        
        if (storeRNG == 0){
            store = -1;
        } else {
            store = 1;
        }
    }
    
    public void act (){
        if (atDoor == false){
            moveToDoor();
        }
        
        if (atDoor && store == -1 && atCounter == false){
            order();
        }
    }
    
    public void order (){
        c1 = getWorld().getObjectsAt(Utils.cashier1X, Utils.cashierY, Customer.class);
        c2 = getWorld().getObjectsAt(Utils.cashier2X, Utils.cashierY, Customer.class);
        
        if(c1.size() > 0){
            cash1IsFree = false;
        } else {
            cash1IsFree = true;
        }
    
        if(c2.size() > 0){
            cash2IsFree = false;
        } else {
            cash2IsFree = true;
        }
        
        if(cash1IsFree && atCounter == false){
            setLocation(Utils.cashier1X, Utils.cashierY);
            atCounter = true;
        } else if (cash2IsFree && atCounter == false){
            setLocation(Utils.cashier2X, Utils.cashierY);
            atCounter = true;
        } else {
            setLocation(0, 0);
        }
        
    }
    
    public void moveToDoor(){
        if(this.getObjectsInRange(100, Door.class).size() > 0){
            if(getX() > Utils.door1X && getX() < Utils.door2X){
                setLocation(getX() + (Utils.moveSpeed * store), getY());
            }
            
            if(getY() != Utils.doorY){
                setLocation(getX(), getY() + (Utils.moveSpeed * dir));
            }
            
        } else {
            setLocation(getX(), getY() + (Utils.moveSpeed * dir));
        }
        
        if((getX() == Utils.door1X || getX() == Utils.door2X) && getY() == Utils.doorY){
            atDoor = true;
        }
    }
}
