package com.game.base.uncategorised;

/**
 *
 * @author Christopher
 */
public class GOBall extends GameObject
{
    public static final int SIZE = 16;
    public static final float MAX_SPEEDX = 6f;
    public static final float MAX_SPEEDY = 8f;
    public static final float DAMPING = 0.05f;
    
    public float velX;
    public float velY;
    
    public float startX;
    public float startY;
    
    public GOBall(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZE;
        this.sy = SIZE;
        
        this.startX = x;
        this.startY = y;
        
        velX = -MAX_SPEEDX;
        velY = 0;
    }
    
    @Override
    public void update()
    {
        x += velX;
        y += velY;
    }
    
    public void resetPosition()
    {
        x = startX;
        y = startY;
        
        velY = 0;
        velX *= -1;
    }
    
    public void reverseX(float centre)
    {
        velX *= -1;
        velY += (getCentreY() - centre) * DAMPING;
        
        if (velY > MAX_SPEEDY)
            velY = MAX_SPEEDY;
        if (velY < -MAX_SPEEDY)
            velY = -MAX_SPEEDY;
    }
    
    public void reverseY()
    {
        velY *= -1;
    }
}
