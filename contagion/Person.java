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
    private boolean isIsolating;
    private static int numHealthy = 151;
    private static int numInfected = 0;
    private static int numImmune = 0;
    
    /**
     * Return the number of healthy people
     */
    public static int getNumHealthy()
    {
        return numHealthy;
    }
    
    /**
     * Return the number of infected people
     */
    public static int getNumInfected()
    {
        return numInfected;
    }
    
    /**
     * Return the number of immune people
     */
    public static int getNumImmune()
    {
        return numImmune;
    }
    
    /**
     * Reset the Person class to be used again for another run
     */
    public static void reset()
    {
        numHealthy = 151;
        numInfected = 0;
        numImmune = 0;
    }
    
    /**
     * Create a person with a random initial direction of movement 
     */
    public Person(boolean isolating)
    {
        turn(Greenfoot.getRandomNumber(360));
        isIsolating = isolating;
    }
    
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!isIsolating) {
            move();
        }
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
    
    /**
     *  Try to infect this person.
     *  If they are not immune or infected already, they will be infected
     */
    public void infect()
    {
        if (!beenInfected) {
            infection = INFECTION_TIME;
            numInfected++;
            numHealthy--;
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
    
    public boolean isInfected()
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
            numInfected--;
            numImmune++;
        }
        
    }
}
