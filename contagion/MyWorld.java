import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The world in which the people will move.
 * 
 * @author Rowan Moss
 * @version 1.0
 */
public class MyWorld extends World
{
    private static final int NUMBER_OF_PEOPLE = 150;
    private static final int PERCENT_ISOLATING = 10;
    private static final int SCALE_Y = 2;
    private int maxInfected = 0;
    private int xOffseta = 0;
    private int xOffsetb = 0;
    private int xOffsetc = 0;
    
    /**
     * Create the world and populate it with people
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        getBackground().setColor(Color.BLACK);
        populate(PERCENT_ISOLATING);
    }

    /**
     * do action for every act step
     */
    public void act()
    {
       displayInfo(); 
    }

    /**
     * display the statistics of this population
     */
    private void displayInfo()
    {
        int numHealthy = Person.getNumHealthy();
        int numInfected = Person.getNumInfected();
        int numImmune = Person.getNumImmune();
        
        if (numInfected > maxInfected) {
            maxInfected = numInfected;
        }
        
        showText("Healthy: " + numHealthy, 100,  40);
        showText("Infected: " + numInfected, 100,  60);
        showText("Max Infected: " + maxInfected, 100,  80);
        showText("Immune: " + numImmune, 100,  100);
        
        plotHealthy(numHealthy);
        plotInfected(numInfected);
        plotImmune(numImmune);
    }
    
    /**
     * Plot a single value of numHealthy by drawing on the world background.
     */
    private void plotHealthy(int value)
    { 
        int yOffset = getHeight() - value * SCALE_Y;
        
        getBackground().setColor(Color.BLUE);
        getBackground().drawLine(xOffseta, yOffset, xOffseta, yOffset-4);
        xOffseta++;
    }
    
    /**
     * Plot a single value of numInfected by drawing on the world background.
     */
    private void plotInfected(int value)
    { 
        int yOffset = getHeight() - value * SCALE_Y;
        
        getBackground().setColor(Color.ORANGE);
        getBackground().drawLine(xOffsetb, yOffset, xOffsetb, yOffset-4);
        xOffsetb++;
    }
    
    /**
     * Plot a single value of numImmune by drawing on the world background.
     */
    private void plotImmune(int value)
    { 
        int yOffset = getHeight() - value * SCALE_Y;
        
        getBackground().setColor(Color.GREEN);
        getBackground().drawLine(xOffsetc, yOffset, xOffsetc, yOffset-4);
        xOffsetc++;
    }

    /**
     * Populate the world with all the initial actors, and one infected person.
     */
    private void populate(int percentIsolating)
    {
        boolean isolate;
        Person.reset();
        Person infectedPerson = new Person(false);
        infectedPerson.infect();
        addObject(infectedPerson, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        
        for (int i=0; i< NUMBER_OF_PEOPLE; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            if (Greenfoot.getRandomNumber(100) < percentIsolating) {
                isolate = true;
            }
            else {
                isolate = false;
            }
            addObject(new Person(isolate), x, y);
        }
        showText("Isolating: " + percentIsolating + "%", 100, 20);
    }
}
