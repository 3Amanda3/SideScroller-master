import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Amanda Schepp 
 * Mr.Hardman
 * Assignment 1, sideScroller
 * Feb 23
 */
public class Ghost extends Actor
{
    
    public Ghost()
    {
     GreenfootImage image1 = new GreenfootImage("Ghost2.png"); 
     getImage().scale(30, 30); 
    }
    
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param there are no parameters
     * @return nothing is returned
     */
    public void act() 
    {
        move(-3);
        
        if(getX() <= 0)
        {
          ScrollerWorld world = (ScrollerWorld)getWorld();
          getWorld().removeObject(this);  
          
        }
    }  
    
    
}
