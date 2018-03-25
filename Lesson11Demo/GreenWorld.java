import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenWorld extends World
{
    /**
     * Constructor for objects of class GreenWorld.
     * 
     */
    public GreenWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bgImage = new GreenfootImage(1,1);
        bgImage.setColor(Color.GREEN);
        bgImage.drawRect(0, 0, 1, 1);
        setBackground(bgImage);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,309,198);
        
    }
}
