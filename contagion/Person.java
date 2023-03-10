import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A person in a virus simulation
 * 
 * @author Rowan Moss
 * @version 1.0
 */
public class Person extends Actor
{
    /**
     * Create a person with a random initial direction of movement 
     */
    public Person()
    {
        turn(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(2);
        if (isAtEdge()) {
            turn(Greenfoot.getRandomNumber(360));
        }
    }
}
