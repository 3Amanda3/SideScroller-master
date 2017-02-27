import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Amanda Schepp 
 * Mr.Hardman
 * Assignment 1, sideScroller
 * Feb 23
 */
public class Hero extends Actor
{
    private GreenfootImage original = new GreenfootImage("Hero.png" );
    private GreenfootImage jumping = new GreenfootImage("Hero_Jumping.png" );

    private int y = 0;
    private int ySpeed = 1;
    private int smallUp = -6;
    private int up = -15;
    private boolean cannotJump = false;
    private boolean lookingRight = true;
    
    
    /**
     * Hero scales the original and jumping images, mirror the 
     * original image horizontally, and set the image of the hero to the original
     * variable
     *  @param there are no parameters
     * @return nothing is returned
     */
     public Hero()
    {
        original.scale(30, 30);
        jumping.scale(32, 32);
        original.mirrorHorizontally();
        setImage(original);
    }
         
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever //i fixed this comment block
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param there are no parameters
     * @return nothing is returned
     */
    public void act() 
    {
        movement();                
        checkCollision();
        
    }
    
    /**
     * movement will let the user move mario with the arrow keys //i fixed this comment block
     * @param there are no parameters
     * @return nothing is returned
     */
    private void movement()
    {
        if( Greenfoot.isKeyDown("right"))
        {
            if(lookingRight == false)
            {
                original.mirrorHorizontally();
                jumping.mirrorHorizontally();
            }
            
            lookingRight = true;
            setLocation( getX() + 3, getY());
        }
        
          if( Greenfoot.isKeyDown("left"))
        {
            if(lookingRight == true)
            {
                original.mirrorHorizontally();
                jumping.mirrorHorizontally();
                
            }
            lookingRight = false;
            setLocation( getX() - 3, getY());
        }
        
        if( Greenfoot.isKeyDown("up"))
        {
          if(cannotJump == false)
          {
               setImage(jumping);
               y = up;
               fall();
               
          }      
        }
        
        if( getY() >= 360)
        {
          setLocation(getX(), 370);
          y = 0;
        }
    }
           
    /**
     * checkCollision will check to see if mario is touching the Enemy or ghost or luck actors
     *  @param there are no parameters
     * @return nothing is returned
     */
    
    private void checkCollision()
    {
         ScrollerWorld world = (ScrollerWorld)getWorld();
         
         if(getOneObjectAtOffset(0, getImage().getHeight()-15, Enemy.class) != null )
         {
            getWorld().removeObject(getOneObjectAtOffset(0, getImage().getHeight()-15, Enemy.class));
            world.addScore();
            y = smallUp;
            fall();
         }
         
         else if(isTouching(Enemy.class) )
         {
            world.gameOver();
         }
         
         else if(isTouching(Ghost.class) )
         {
            world.gameOver();
         }
         
         else if(getOneObjectAtOffset(0, getImage().getHeight()-15, Luck.class) != null )
         {
            getWorld().removeObject(getOneObjectAtOffset(0, getImage().getHeight()-15, Luck.class));
            world.addScore5();
            y = smallUp;
            fall();     
         }
         
         else if(getOneObjectAtOffset(0, getImage().getHeight()-15, Platform.class) != null )
         {
             setImage(original);
            cannotJump = false;
            y = 0;
         }
         
         else
         {
             fall();
         }
    }
        
    /**
     * fall will get mario to go down after he jumps up
     *  @param there are no parameters
     * @return nothing is returned
     */
    private void fall()
    {
      cannotJump = true;
      setLocation(getX(), getY() + y);
      y = y + ySpeed;
      
    }
    
}
