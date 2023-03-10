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
    private static final int SCALE_Y = 2;
    private int maxInfected = 0;
    private int xOffset = 0;
    
    /**
     * Create the world and populate it with people
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        getBackground().setColor(Color.BLACK);
        populate();
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
        int numInfected = Person.getNumInfected(); 
        if (numInfected > maxInfected) {
            maxInfected = numInfected;
        }
        
        showText("Infected: " + Person.getNumInfected(), 100,  20);
        showText("Max Infected: " + maxInfected, 100,  40);
        
        plotValue(numInfected);
    }
    
    /**
     * Plot a single value by drawing on the world background.
     */
    private void plotValue(int value)
    { 
        int yOffset = getHeight() - value * SCALE_Y;
        
        getBackground().drawLine(xOffset, yOffset, xOffset, yOffset-4);
        
        xOffset++;
    }

    /**
     * Populate the world with all the initial actors, and one infected person.
     */
    private void populate()
    {
        Person.reset();
        Person infectedPerson = new Person();
        infectedPerson.infect();
        addObject(infectedPerson, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        
        for (int i=0; i< NUMBER_OF_PEOPLE; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Person(), x, y);
        }
    }
}
