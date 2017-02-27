import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Amanda Schepp 
 * Mr.Hardman
 * Assignment 1, sideScroller
 * Feb 21
 */
public class Enemy extends Actor
{
    private int imageCounter = 3;
    
    /**
     * Ememy scales the image and adds to the counter
     * @param there are no parameters
     * @return nothing is returned
     */
    public Enemy()
    {
     GreenfootImage image1 = new GreenfootImage("Goomba.png"); 
     getImage().scale(25, 25); 
     
     if(imageCounter >= 3)
     {
       image1.mirrorHorizontally();
     }
     else
     {
         imageCounter++;
     }     
    }
            
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param there are no parameters
     * @return nothing is returned
     */
    public void act() 
    {
        move(-2);
        
        if(getX() <= 0)
        {
          ScrollerWorld world = (ScrollerWorld)getWorld();
          getWorld().removeObject(this);  
          world.subScore();
        }                                               
    }
    
    
}
