import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button with Plus image. To be clicked to increase value in SettingWorld
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public class PlusButton extends Button
{
    public PlusButton() {
        super();
        // pre-load files
        this.image = new GreenfootImage("plusButton.png");
        this.downImage = new GreenfootImage("plusButtonDOWN.png");
        this.hoverImage = new GreenfootImage("plusButtonHOVER.png");
    }
    
    protected void onClick() {   
    }
}
