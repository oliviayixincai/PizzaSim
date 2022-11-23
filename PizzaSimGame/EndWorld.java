import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> main

/**
 * EndWorld is an class that show the final result fo the simulation and display
 * confetti effect.
 * 
 * @author Yixin Cai & Gloria Chan
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
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
<<<<<<< HEAD
    private GreenfootSound winSound;
=======
    private ArrayList<GreenfootSound> pausedSounds;
>>>>>>> main
    
    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld(int result, int level, int money)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        this.result = result;
        this.level = level;
        this.money = money;
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
<<<<<<< HEAD
        winSound = new GreenfootSound("win.wav");
        winSound.play();
=======
        pausedSounds = new ArrayList<GreenfootSound>();
>>>>>>> main
        if (result == 0 ) {
            setBackground(backgroundImages[result]);
            winFlashingText = new FlashingText(new GreenfootImage(winTexts[result]));
        }
        else {
            setBackground(backgroundImages[result]);
            winFlashingText = new FlashingText(new GreenfootImage(winTexts[result]));
        }
        
        addObject(levelNumLabel, 450, 620);
        addObject(amountMoneyLabel, 450, 705);
        addObject(winFlashingText, 296, 150);
        addObject(confetti, 512, 400);
        addObject(tryAgainButton, 830, 750);
    }
    
<<<<<<< HEAD
    public void started() {
        Utils.backgroundSound.playLoop();
        winSound.play();
    }
    
    public void stopped() {
        Utils.backgroundSound.pause();
        winSound.pause();
    }
}

=======
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
>>>>>>> main
