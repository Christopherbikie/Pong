package com.game.base.uncategorised.entity;

import com.game.base.uncategorised.Physics;

/**
 *
 * @author Christopher
 */
public class Wall extends Entity
{
    public static final int STDSIZE = 16;
    private Ball ball;
    
    public Wall(float x, float y, float sx, float sy, Ball ball)
    {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        this.ball = ball;
    }
    
    @Override
    public void update()
    {
        if (Physics.checkCollisions(this, ball))
            ball.reverseY();
    }
}
