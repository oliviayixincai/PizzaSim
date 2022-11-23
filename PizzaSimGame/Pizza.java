import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Pizza is a Greenfoot Actor used to show the creation process of the pizza after being ordered by a customer.
 * <p> One pizza topping layer is added after certain acts from the topping added before.
 * <p> It cooks and burns pizza when it remains in the oven for too long.
 * 
 * @Yuxin Li (Yuxin Li) 
 * @version Novbember 2022
 * 
 */ 
public class Pizza extends Actor
{
    private String[] toppings;
    private String sauce;
    private boolean burn = false;
    private boolean doughFinished = false, toppingsFinished = false, sauceFinished = false, cheeseFinished = false;
    private boolean firstStage_finished = false;
    private boolean cooked = false;
    private Cashier cashier;
    private Customer customer;
    private int chef_Xoffset = 50, chef_Yoffset = 0;
    private boolean inOven;
    private int cookTime = 900, price;
    private int toppingTime = 60;
    private SimpleTimer timer = new SimpleTimer();
    
    private boolean hasCheese;
    
    private GreenfootImage pizza = new GreenfootImage("pizzaBase.png");
    private GreenfootImage imageSauce;

    private static GreenfootImage crust = new GreenfootImage("cooked.png");
    private static GreenfootImage burned=new GreenfootImage("burned.png");
    private GreenfootImage cheese = new GreenfootImage("cheese.png");
    private int imageIndex = 0, toppingIndex = 0;
    private int changeTime = 0;
    private boolean hasCashier = false, hasChef = false;
    private boolean atCashierCounter = false, paid = false;

    private boolean customerPickedUp = false;
    
    /**
     * initialize a pizza that correspond to a customer's order after 
     * a customer comes in the store and orders
     * 
     * @param strings array consists of the customer order
     * @param sauce the type of sauce the customer wants
     * @customer theCustomer the customer that orders this pizza
     */
    public Pizza(String[] strings, String sauce, Customer theCustomer){
        toppings = strings;
        this.sauce = sauce;
        hasCheese = cheese; 
        atCashierCounter = false;
    }
    
    public void act()
    {
        if(customerPickedUp == false){
            if (!doughFinished)
            {
                spreadDough();
            }
            if(doughFinished && !sauceFinished)
            {   
                toppingTime--;
                addSauce(sauce);
            }
            if(doughFinished && sauceFinished && !cheeseFinished){
                addCheese(hasCheese);
            }
            if(doughFinished && sauceFinished && cheeseFinished && !toppingsFinished)
            {
                toppingTime--;
                addToppings(toppings);
            }
        } else {
            switch (customer.getRotation()){
                case People.UP:
                    setLocation(customer.getX(), customer.getY() - (customer.getImage().getHeight()/2 + getImage().getHeight()/2));
                    break;
                case People.DOWN:
                    setLocation(customer.getX(), customer.getY() +  getImage().getHeight()/2);
                    break;
                case People.LEFT:
                    setLocation(customer.getX() - getImage().getWidth() + 5, customer.getY());
                    break;
                case People.RIGHT:
                    setLocation(customer.getX()  + getImage().getWidth() - 5, customer.getY());
                    break;
            }
            atEdge();
        }
    }
    
    /**
     * set the dough Image
     */
    public void spreadDough(){
        pizza.scale(50,50);
        setImage(pizza);
        doughFinished = true;
    }
    
    public void addSauce(String sauce)
    {
        if(toppingTime == 0)
        {
            imageSauce = new GreenfootImage("sauce" + sauce + ".png");
            imageSauce.scale(50, 50);
            getImage().drawImage(imageSauce, 0 , 0);
            sauceFinished = true;
            toppingTime = 60;
        }
    }
    
    public void addCheese(boolean hasCheese){
        if (hasCheese){
            cheese.scale(50, 50);
            getImage().drawImage(cheese, 0 , 0);
        }
        cheeseFinished = true;
    }
    
    /**
     * add one new topping to pizza every 60 acts 
     * @param strings The string array consists of the topping that the customer orders
     */
    public void addToppings(String[] strings){
        if(toppingIndex < strings.length && toppingTime==0){
            GreenfootImage topping = new GreenfootImage(toppings[toppingIndex] + ".png");
            topping.scale(50,50);
            getImage().drawImage(topping, 0, 0);
            toppingIndex++;
            toppingTime = 60;
        }
        if(toppingIndex == strings.length)
        {
            toppingsFinished = true;
        }
    }
    
    /**
     * get the cook time required for the pizza
     * @return cookTime the cook time required for the pizza
     */
    public int getCookTime(){
        return cookTime;
    }
    
    public void isPickedUp(){
        inOven = false;
    }
    /**
     * return if the pizza is in oven, in other word, if the pizza is picked up by a cashier
     * @return inOven True if the pizza is in oven, False if the pizza is not in oven
     */
    public boolean isInOven(){
        return inOven;
    }
    
    public void goInOven(){
        int x = 0; 
        switch (getX()){
            case 160:
                x = 145;
                break;
            case 222:
                x = 217;
                break;
            case 280:
                x = 290;
                break;
            case 744:
                x = 736;
                break;
            case 802:
                x = 809;
                break;
            case 864:
                x = 880;
                break;
        }
        getWorld().addObject(new Clock(cookTime, this), x, getY() - 49);
        inOven = true;
    }
    
    /**
     * return if the dough is finished 
     * @return doughFinished True if the dough is finished, False if it is not
     */
    public boolean isDoughFinished()
    {
        return doughFinished;
    }
    
    /**
     * return if the topping is finished added 
     * @return toppingsFinished True if the toppings are finished, False if not
     */
    public boolean toppingsFinished(){
        return toppingsFinished;
    }
    
    /**
     * check if the pizza is cooked 
     */
    public boolean isCooked(){
        return cooked;
    }
    
    public void burnPizza(){
        //add a dark layer on the pizza
        //drawImage
        burned.scale(50,50);
        burned.setTransparency(100);
        getImage().drawImage(burned,0,0);
        burn=true;
    }
    /**
     * cook the pizza by adding a golden layer at the top of the pizza
     */
    public void cookPizza(){
        //add a golden crust layer on pizza
        crust.scale(50,50);
        crust.setTransparency(90);

        getImage().drawImage(crust,0,0);
        cooked=true;
    }
    
    //andy code, setter called by customer to set locations
    public void setCPU(Customer customer){
        customerPickedUp = true;
        this.customer = customer;
    }
    
    public void atEdge(){
        if(getY() <= 81 || getY() >= 799){
            getWorld().removeObject(this);
        }
    }
    
    public String[] getToppings(){
        return toppings;
    }
    
    public String getSauce(){
        return sauce;
    }
    
}
