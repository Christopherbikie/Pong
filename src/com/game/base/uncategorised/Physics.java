package com.game.base.uncategorised;

import com.game.base.uncategorised.entity.Entity;

import java.awt.Rectangle;

/**
 *
 * @author Christopher
 */
public class Physics
{
    public static boolean checkCollisions(Entity go1, Entity go2)
    {
        Rectangle r1 = new Rectangle((int)go1.getX(),(int)go1.getY(),(int)go1.getSX(),(int)go1.getSY());
        Rectangle r2 = new Rectangle((int)go2.getX(),(int)go2.getY(),(int)go2.getSX(),(int)go2.getSY());
        
        return r1.intersects(r2);
    }
}
