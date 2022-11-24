import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button with Minus image. To be clicked to reduce value in SettingWorld
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public class MinusButton extends Button
{
    /**
     * Constructor of MinusButton.
     */
    public MinusButton() {
        super();
        // pre-load files.
        this.image = new GreenfootImage("minusButton.png");
        this.downImage = new GreenfootImage("minusButtonDOWN.png");
        this.hoverImage = new GreenfootImage("minusButtonHOVER.png");
    }
    
    protected void onClick() {   
    }
}
