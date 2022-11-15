import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Order here.
 * 
 * @Yuxin Li (your name) 
 * @version (a version number or a date)
 * 
 * chatBox image by Sallie from: 
 * https://www.vhv.rs/viewpic/oobJ_pixel-chat-bubble-png-transparent-png/
 */
public class Order extends Actor
{
    /**
     * Act - do whatever the Order wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String[] toppings;
    private String sauce;
    private GreenfootImage chatBox=getImage();
    private GreenfootImage topping;
    private GreenfootImage theSauce;
    private GreenfootImage dough;
    private int a;
    public Order(String sauceType, String[] toppingTypes){
        toppings=toppingTypes;
        sauce=sauceType;
        dough=new GreenfootImage("dough.png");
        chatBox.drawImage(dough, 12, 2);
        a=0;
        
    }
    /**
     * draw the order picture above the head of each customer
     */
    public void drawOrder(){
        theSauce=new GreenfootImage("sauce"+sauce+".png");
        chatBox.drawImage(theSauce,12,2);
        for(int i=0; i<toppings.length; i++){
            topping = new GreenfootImage(toppings[i] + ".png");
            chatBox.drawImage(topping, 12, 2);
        }
    }
    public void addedToWorld(World w){
        drawOrder();
    }
}