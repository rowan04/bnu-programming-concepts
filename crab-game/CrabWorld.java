import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Worm worm = new Worm();
        addObject(worm,151,122);
        Worm worm2 = new Worm();
        addObject(worm2,395,86);
        Worm worm3 = new Worm();
        addObject(worm3,484,226);
        Worm worm4 = new Worm();
        addObject(worm4,420,343);
        Worm worm5 = new Worm();
        addObject(worm5,258,231);
        Worm worm6 = new Worm();
        addObject(worm6,141,437);
        Worm worm7 = new Worm();
        addObject(worm7,437,472);
        Worm worm8 = new Worm();
        addObject(worm8,144,279);
        Crab crab = new Crab();
        addObject(crab,252,361);
        Lobster lobster = new Lobster();
        addObject(lobster,38,33);
        worm4.setLocation(422,359);
        Lobster lobster2 = new Lobster();
        addObject(lobster2,451,155);
        Lobster lobster3 = new Lobster();
        addObject(lobster3,96,526);
    }
}