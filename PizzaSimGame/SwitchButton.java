import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The switch button to switch setting views betweeen PAPA and MAMA pizzeria.
 * 
 * @author Yixin Cai
 * @version November 2022
 */
public class SwitchButton extends Button
{
    // pre-load files
    GreenfootImage switchImageRight = new GreenfootImage("rightButton.png");
    GreenfootImage switchDownImageRight = new GreenfootImage("rightButtonDOWN.png");
    GreenfootImage switchImageHoverRight = new GreenfootImage("rightButtonHOVER.png");
    GreenfootImage switchImageLeft = new GreenfootImage("leftButton.png");
    GreenfootImage switchDownImageLeft = new GreenfootImage("leftButtonDOWN.png");
    GreenfootImage switchImageHoverLeft = new GreenfootImage("leftButtonHOVER.png");
    
    public SwitchButton() {
        super();
        
        this.image = switchImageLeft;
        this.downImage = switchDownImageLeft;
        this.hoverImage = switchImageHoverLeft;
    }
    
    /**
     * Switch the images if in different pizzeria.
     * @param toLeft True if is going to Mama pizzeria, Falso otherwise.
     */
    public void switchImage(boolean toLeft) {
        if (toLeft) {
            this.image = switchImageLeft;
            this.downImage = switchDownImageLeft;
            this.hoverImage = switchImageHoverLeft;
        }
        else {
            this.image = switchImageRight;
            this.downImage = switchDownImageRight;
            this.hoverImage = switchImageHoverRight;
        }
    }
    
    protected void onClick() {   
    }
}
