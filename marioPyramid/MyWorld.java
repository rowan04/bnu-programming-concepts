import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        buildPyramid();
    }
    
    public void buildPyramid()
    {
        int size = getPyramidSize();
        
        int yStart = 200; 
        int yEnd = yStart - size;
        int xStart = 50; 
        int xEnd = xStart + size;
        
        // each row
        for(int y = yStart; y > yEnd;)
        {
            //left half
            for (int x = xStart; x < xEnd;)
            {
                Block Block = new Block();
                addObject(Block, x, y);
                x = x + 300;
            }
            
            //right half
            for (int x = xEnd+2; x < xEnd + 2 + (xEnd - xStart);)
            {
                Block Block = new Block();
                addObject(Block, x, y);
                x = x + 300;
            }
            xStart= xStart + 300;
            y = y - 300;
        }
    }
    
    private int getPyramidSize()
    {
        String getSize = Greenfoot.ask("Enter the size of the pyramid (between 1-8)");
        int size = Integer.parseInt(getSize); 
        
        if (size < 1)
        {
            sizeTooSmall();
        }
        else if (size > 8 )
        {
            sizeTooBig();
        }
        //else {
        return size;
        //}
    }
    
    private int sizeTooSmall()
    {
        String getSize = Greenfoot.ask("Input was too small. It needs to be between 1 and 8. Enter the size of the pyramid:");
        int size = Integer.parseInt(getSize); 
        
        if (size < 1)
        {
            sizeTooSmall();
        }
        else if (size > 8 )
        {
            sizeTooBig();
        }
        //else {
        return size;
        //}
    }
    
    private int sizeTooBig()
    {
        String getSize = Greenfoot.ask("Input was too big. It needs to be between 1 and 8. Enter the size of the pyramid:");
        int size = Integer.parseInt(getSize); 
        
        if (size < 1)
        {
            sizeTooSmall();
        }
        else if (size > 8 )
        {
            sizeTooBig();
        }
        //else {
        return size;
        //}
    }
}
