import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * EndWorld is an class that show the final result fo the simulation and display
 * confetti effect with sound.
 * TryAgain button will be added in the EndWorld for player to restart.
 * 
 * Credits
 * "Megapixel" font and "Crown" graphic from Canva (https://www.canva.com/).
 * 
 * @author Yixin Cai & Gloria Chan
 * @version November 2022
 */
public class EndWorld extends World
{
    // Declare cariables and objects
    private int result;
    private int level;
    private int money;
    private GreenfootImage backgroundImages[];
    private GreenfootImage winTexts[];
    private FlashingText winFlashingText;
    private Label levelNumLabel;
    private Label amountMoneyLabel;
    private TryAgainButton tryAgainButton;
    private Confetti confetti;
    private GreenfootSound winSound;
    private ArrayList<GreenfootSound> pausedSounds;
    
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld(int result, int level, int money)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        // Initiate variables and objects
        this.result = result;
        this.level = level;
        this.money = money;
        // pre-load
        winTexts = new GreenfootImage[] {
            new GreenfootImage("mamaWinText.png"),
            new GreenfootImage("papaWinText.png")
        };
        backgroundImages = new GreenfootImage[] {
            new GreenfootImage("mamaWin.png"),
            new GreenfootImage("papaWin.png")
        };
        this.levelNumLabel = new Label(level, 50, new Color(253, 218, 13));
        this.amountMoneyLabel = new Label (money, 50, new Color(253, 218, 13));
        this.tryAgainButton = new TryAgainButton();
        this.confetti = new Confetti();
        // pre-load
        winSound = new GreenfootSound("win.wav");
        winSound.play();
        pausedSounds = new ArrayList<GreenfootSound>();
        // Set images of Mama win with flashign "MAMA WON" text.
        if (result == 0 ) {
            setBackground(backgroundImages[result]);
            winFlashingText = new FlashingText(new GreenfootImage(winTexts[result]));
        }
        // Set images of Papa win with flashign "MAMA WON" text.
        else {
            setBackground(backgroundImages[result]);
            winFlashingText = new FlashingText(new GreenfootImage(winTexts[result]));
        }
        // Add objects 
        addObject(levelNumLabel, 450, 620);
        addObject(amountMoneyLabel, 450, 705);
        addObject(winFlashingText, 296, 150);
        addObject(confetti, 512, 400);
        addObject(tryAgainButton, 830, 750);
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
            if (pausedSounds.contains(sound.getSound())) {
                sound.playSound();
            }
        }
        // play background sound in loop
        Utils.backgroundSound.playLoop();
    }
}
