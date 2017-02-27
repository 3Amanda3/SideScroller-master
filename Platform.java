import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Amanda Schepp 
 * Mr.Hardman
 * Assignment 1, sideScroller
 * Feb 21
 */
public class Platform extends Actor
{
    
    /**
   * Platform scales the platfrom image
   * @param there are no parameters
   * @return nothing is returned
   */
  public Platform()
    {
        getImage().scale(100, 16);

    }
        
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param there are no parameters
     * @return nothing is returned
     */
    public void act() 
    {
        
       
        if( Greenfoot.isKeyDown("right"))
        {
          move(-1);  
        }
        
        if(getX() <= 0)
        {
          getWorld().removeObject(this);  
        }
        
       
    }    
}
