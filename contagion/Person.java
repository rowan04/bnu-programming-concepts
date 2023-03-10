import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A person in a virus simulation
 * 
 * @author Rowan Moss
 * @version 1.0
 */
public class Person extends Actor
{
    private static final int INFECTION_TIME = 300;
    private int infection = 0;
    private boolean beenInfected = false;
    
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
        if (isInfected()) {
            infectOthers();
            heal();
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
        if (!beenInfected) {
            infection = INFECTION_TIME;
            setImage("ppl3.png");
            beenInfected = true;
        }
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
    
    private boolean isInfected()
    {
        return infection > 0;
    }
    
    /**
     * If we are infected, execute the healing process.
     * If infection reaches zero, we are immune.
     */
    private void heal()
    {
        if (isInfected()) {
            infection--;
        }
        if (infection == 0) {
            setImage("ppl2.png");
        }
        
    }
}
