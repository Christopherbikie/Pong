package com.game.base.uncategorised;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Christopher
 */
public class Main
{
    private static Game game;
    private static PauseScreen pauseScreen;

	public static boolean paused = false;

	public static int width = 800;
	public static int height = 600;

    public static void main(String[] args)
    {
        //Initialise program
        initDisplay();
        initGL();

        initGame();

        gameLoop();
        cleanUp();
   }

    private static void initGame()
    {
        game = new Game();
	    pauseScreen = new PauseScreen();
    }

    private static void getInput()
    {
        game.getInput();
    }

    private static void update()
    {
        game.update();
    }

    private static void render()
    {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        game.render();

	    if (paused) {
		    pauseScreen.render();
	    }

        Display.update();
        Display.sync(60);
    }

    private static void gameLoop()
    {
        while(!Display.isCloseRequested())
        {
            if (!paused) {
	            getInput();
	            update();
	            render();
            } else {
	            render();
	            getInput();
            }
        }
    }

	public static void pause() {
		paused = !paused;
	}

    private static void initGL()
    {
	    glEnable(GL_TEXTURE_2D);
	    glShadeModel(GL_SMOOTH);
	    glDisable(GL_DEPTH_TEST);
	    glDisable(GL_LIGHTING);

	    glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	    glClearDepth(1);

	    glViewport(0,0,width,height);
	    glMatrixMode(GL_MODELVIEW);

	    glMatrixMode(GL_PROJECTION);
	    glLoadIdentity();
	    glOrtho(0, width, height, 0, 1, -1);
	    glMatrixMode(GL_MODELVIEW);
    }

    private static void cleanUp()
    {
        Display.destroy();
        Keyboard.destroy();
    }

    private static void initDisplay()
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setVSyncEnabled(true);
            Keyboard.create();
        }
        catch (LWJGLException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
