import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button with Plus image. To be clicked to increase value in SettingWorld
 * 
 * @author Yixin Cai
 * @version (a version number or a date)
 */
public class PlusButton extends Button
{
    public PlusButton() {
        super();
        
        this.image = new GreenfootImage("plusButton.png");
        this.downImage = new GreenfootImage("plusButtonDOWN.png");
        this.hoverImage = new GreenfootImage("plusButtonHOVER.png");
    }
    
    protected void onClick() {   
    }
}
