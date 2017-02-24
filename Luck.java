import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Luck here.
 * @author Amanda Schepp 
 * Mr.Hardman
 * Assignment 1, sideScroller
 * Feb 23
 */
public class Luck extends Actor
{
     private int imageCounter = 3;
    
    /**
     * Luck scales the image and adds to the counter
     * @param there are no parameters
     * @return nothing is returned
     */
    public Luck()
    {
     GreenfootImage image1 = new GreenfootImage("shamrock.png"); 
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
        }                                               
    }  
    
    
}


