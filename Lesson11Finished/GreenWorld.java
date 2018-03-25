import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenWorld extends World
{
    String[] textMap = {
        "****.******.***",
        "...............",
        "*.**.*.********",
        "*.*...........*",
        "*.*.*.*.*.*.*.*",
        "*.*.*P*.*.*.*.*",
        "*.*...........*",
        "*.*.**.*.****.*",
        ".......*.......",
        "****.******.***"
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
        prepare();
        drawMap();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        
    }
    
    private void drawMap(){
        for(int i = 0; i < textMap.length;i++){
            String mapLine = textMap[i];
            for(int j = 0; j < mapLine.length(); j++){
                char mapChar = mapLine.charAt(j);
                int y = i * 40 + 20;
                int x = j * 40 + 20;
                switch(mapChar){
                    case '*':
                        addObject(new Obstacle(), x, y);
                        break;
                    case '.':
                        addObject(new Target(), x, y);
                        break;
                    case 'P':
                        addObject(new Player(), x, y);
                    default:
                        break;
                }
            }
        }
    }
}
