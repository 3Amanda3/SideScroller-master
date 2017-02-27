import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Amanda Schepp 
 * Mr.Hardman
 * Assignment 1, sideScroller
 * Feb 23
 */
public class ScrollerWorld extends World
{
    private int platformCounter = 25;
    private int score = 0;

    /**
     * ScrollerWorld will load the world
     * @param there are no parameters
     * @return Scrollerworld does not return anything
     */
    public ScrollerWorld()
    {    

        super(600, 400, 1);

        prepareWorld();

        displayScore();

    }

    /**
     * prepareWorld adds objects to world to prepare the game for use
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareWorld()
    {
        for(int i = 0; i <= getWidth()/50; i++ )
        {
            addObject( new Platform(), i *50, getHeight()-8); 
        }

        addObject( new Hero(), 30, getHeight()-30); 
        
    }

    /**
     * Act when run will add obects to the world at random and check if score is below 0 and end the game.
     * @param there are no parameters
     * @return nothing is returned
     */

    public void act()
    {
        if( Greenfoot.isKeyDown("right"))
        {

            if( platformCounter >= 25)
            {
                platformCounter = 0;
                addObject( new Platform(), getWidth()-25, getHeight()-8); 
            }
            else
            {
                platformCounter++; 
            }           
        }      
        
        if(Greenfoot.getRandomNumber(150)<1)
        {
            addObject( new Enemy(), 599, getHeight()-27);  
        }
        
         if(Greenfoot.getRandomNumber(500)<1)
        {
            addObject( new Ghost(), 599, getHeight()-27);  
        }
        
         if(Greenfoot.getRandomNumber(1000)<1)
        {
            addObject( new Luck(), 599, getHeight()-27);  
        }
        
        if(score < 0)
        {
            gameOver();
        }
        
        displayScore();
    }

    /**
     *  gameOver will display the game over and stop the program
     *  @param there are no parameters
     *  @return nothing is returned
     */
    public void gameOver()
    {
        showText("YOU HAVE LOST! Score: " +score ,getWidth()/2, getHeight()/2);
        Greenfoot.stop();       
    }

    /**
     * displayScore will display the score 
     * @param there are no parameters
     * @return nothing is returned
     */
    private void displayScore()
    {
        showText("Score: " +score ,50, 25);  
    }

    /**
     * addScore when run will add one to the score when run
     * @param there are no parameters
     * @return nothing is returned
     */
    public void addScore()
    {
        score++;  
    }
    
    /**
     * addScore5 when run will add five to the score when run
     * @param there are no parameters
     * @return nothing is returned
     */
    public void addScore5()
    {
        score = score + 5;  
    }
    
     /**
     * subScore when run will subract one from the score when run
     * @param there are no parameters
     * @return nothing is returned
     */
    public void subScore()
    {
        score--;  
    }

    
   
}
    