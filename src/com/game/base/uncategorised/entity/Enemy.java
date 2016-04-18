package com.game.base.uncategorised.entity;

import com.game.base.uncategorised.Physics;

/**
 *
 * @author Christopher
 */
public class Enemy extends Entity
{
    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;
    public static final float MAX_SPEEDY = 4f;
    public static final float DAMPING = 0.05f;
    
    private Ball ball;
    
    public Enemy(float x, float y, Ball ball)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.ball = ball;
    }
    
    @Override
    public void update()
    {
        if (Physics.checkCollisions(this, ball))
            ball.reverseX(getCentreY());
        
        float speed = ball.getCentreY() - getCentreY();
        
        if (speed > MAX_SPEEDY)
            speed = MAX_SPEEDY;
        if (speed < -MAX_SPEEDY)
            speed = -MAX_SPEEDY;
        
        y += speed;
    }
}
