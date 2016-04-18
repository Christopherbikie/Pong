package com.game.base.uncategorised;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.Font;

/**
 * Created by Christopher on 18/04/2016.
 */
public class PauseScreen {

	private static UnicodeFont font;

	public PauseScreen() {
		Font awtFont = new Font("Virdana", Font.PLAIN, 48);
		font = new UnicodeFont(awtFont);
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addAsciiGlyphs();
		try {
			font.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render() {
		Draw.renderText("Paused", font, 320, Main.height / 2 - font.getLineHeight());
	}
}
