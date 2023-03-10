import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world in which the people will move.
 * 
 * @author Rowan Moss
 * @version 1.0
 */
public class MyWorld extends World
{
    private static final int NUMBER_OF_PEOPLE = 150;
    /**
     * Create the world and populate it with people
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        populate();
    }

    /**
     * Populate the world with all the initial actors.
     */
    private void populate()
    {
        for (int i=0; i< NUMBER_OF_PEOPLE; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Person(), x, y);
        }
    }
}
