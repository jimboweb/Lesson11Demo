import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenWorld extends World
{
    String[] map ={ 
    "**** **********",
    "               ",
    "* ** * ********",
    "* *  *        *",
    "* *  * * * *  *",
    "* *  *P* * *  *",
    "* *           *",
    "* *  * *****  *",
    "       *       ",
    "**** **********"
    };
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
        drawMap();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    private void drawMap(){
        for(int i=0;i<map.length;i++){
            String mapLine = map[i];
            for(int j=0;j<mapLine.length();j++){
                char character = mapLine.charAt(j);
                Actor newActor = getMapActor(character);
                if(newActor!=null){
                    addObject(newActor, j*40+20,i*40+20);
                }
            }
        }
    
    }
    
    private Actor getMapActor(char character){
        switch(character){
            case '*':
                return new Obstacle();
            case ' ':
                return new Aphid();
            case 'P':  
                return new Player();
            default:
                return null;
        }
    }
}
