import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A person in a virus simulation
 * 
 * @author Rowan Moss
 * @version 1.0
 */
public class Person extends Actor
{
    private boolean isInfected = false;
    
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
        move();
        if (isInfected) {
            infectOthers();
        }
    }
    
    /**
     * Move the person randomly on screen.
     */
    private void move()
    {
        move(2);
        if (isAtEdge()) {
            turn(Greenfoot.getRandomNumber(360));
        }
        if (Greenfoot.getRandomNumber(100) <20) {
            turn(Greenfoot.getRandomNumber(81)-40);
        }
    }
    
    public void infect()
    {
        isInfected = true;
        setImage("ppl3.png");
    }
    
    /**
     * Check if we are touching another person. If we are, infect them.
     */
    private void infectOthers()
    {
        Person other = (Person) getOneIntersectingObject(Person.class);
        if (other != null) {
            other.infect();
        }
    }
}
