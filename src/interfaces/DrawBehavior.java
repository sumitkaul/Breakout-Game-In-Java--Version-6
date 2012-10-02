package interfaces;

import game.GameObject;

import java.awt.Graphics;

public interface DrawBehavior {
	public abstract void draw(GameObject gameObject, Graphics g);
}
