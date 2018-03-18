import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int speed = 2;
    int length;
    class Direction {
        public static final int UP = 270;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0;
    }
    
    public Player(){
        length = getImage().getWidth();
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up")){
            setRotation(Direction.UP);
            movePlayer();
        } else if(Greenfoot.isKeyDown("down")){
            setRotation(Direction.DOWN);
            movePlayer();
        } else if(Greenfoot.isKeyDown("left")){
            setRotation(Direction.LEFT);
            movePlayer();
        } else if(Greenfoot.isKeyDown("right")){
            setRotation(Direction.RIGHT);
            movePlayer();
        }
    }    

    public void movePlayer(){
        int currentX = getX();
        int currentY = getY();
        int direction = getRotation();
        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        int adjustedChangeX = adjustOffset(changeX);
        int adjustedChangeY = adjustOffset(changeY);
        Actor obstacle = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Obstacle.class);
        if(obstacle==null){
            setLocation(currentX + changeX,currentY + changeY);
        }
    }

    private int getChangeX(int direction){
        if(direction == Direction.RIGHT){
            return speed;
        }
        if(direction == Direction.LEFT){
            return -speed;
        }
        return 0;
    }

    private int getChangeY(int direction){
        if(direction == Direction.DOWN){
            return speed;
        }
        if(direction == Direction.UP){
            return -speed;
        }
        return 0;
    }

    private int adjustOffset(int offset){
        int signOfOffset = (int)Math.signum(offset);
        int distanceToFront = length/2;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }
}
