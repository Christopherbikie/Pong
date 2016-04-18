package com.game.base.uncategorised.entity;

import com.game.base.uncategorised.Physics;

/**
 *
 * @author Christopher
 */
public class Player extends Entity
{
    public static final int SIZEX = 16;
    public static final int SIZEY = SIZEX * 7;
    public static final float SPEED = 4f;
    
    private Ball ball;
    
    public Player(float x, float y, Ball ball)
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
        if(Physics.checkCollisions(this, ball))
            ball.reverseX(getCentreY());
    }
    
    public void move(float mag)
    {
        y += SPEED * mag;
    }
}
