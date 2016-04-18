package com.game.base.uncategorised;

import com.game.base.uncategorised.entity.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class Game
{
    private ArrayList<Entity> entities;
    private Ball ball;
    private Player player;
    private int playerScore;
    private int enemyScore;
    
    public Game()
    {
        entities = new ArrayList<>();
        
        playerScore = 0;
        enemyScore = 0;
        
        ball = new Ball(Display.getWidth() / 2 - Ball.SIZE / 2, Display.getHeight() / 2 - Ball.SIZE);
        player = new Player(0,Display.getHeight() / 2 - Player.SIZEY / 2, ball);
        
        Enemy enemy = new Enemy(Display.getWidth() - Enemy.SIZEX, Display.getHeight() / 2 - Player.SIZEY / 2, ball);
        
        Wall wall1 = new Wall(0,0,Display.getWidth(), Wall.STDSIZE, ball);
        Wall wall2 = new Wall(0,Display.getHeight() - Wall.STDSIZE, Display.getWidth(), Wall.STDSIZE, ball);
        
        entities.add(ball);
        entities.add(player);
        entities.add(enemy);
        entities.add(wall1);
        entities.add(wall2);
    }
    
    public void getInput()
    {
	    while (Keyboard.next()) {
		    if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && Keyboard.getEventKeyState())
			    Main.pause();
	    }
        if ((Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) && Main.paused == false)
            player.move(-1);
        if ((Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) && Main.paused == false)
            player.move(1);
    }
    
    public void update()
    {
        entities.forEach(Entity::update);
        
        if (ball.getX() > Display.getWidth())
        {
            playerScore++;
            ball.resetPosition();
        }
        
        if (ball.getX() < 0)
        {
            enemyScore++;
            ball.resetPosition();
        }
    }
    
    public void render()
    {
        entities.forEach(Entity::render);
        
        Display.setTitle("Score: P" + playerScore + ":E" + enemyScore);
    }
}
