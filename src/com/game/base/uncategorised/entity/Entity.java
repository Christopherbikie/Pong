package com.game.base.uncategorised.entity;

import com.game.base.uncategorised.Draw;

/**
 *
 * @author Christopher
 */
public abstract class Entity
{
    protected float x;
    protected float y;
    protected float sx;
    protected float sy;
    
    public abstract void update();
    public void render()
    {
        Draw.rect(x,y,sx,sy);
    }
    
    public float getX()
    {
        return x;
    }
    
    public float getY()
    {
        return y;
    }
    
    public float getSX()
    {
        return sx;
    }
    
    public float getSY()
    {
        return sy;
    }
    
    public float getCentreY()
    {
        return y + sy / 2;
    }
}
