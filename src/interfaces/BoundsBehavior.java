package interfaces;

import game.GameObject;

import java.awt.geom.Rectangle2D;

public interface BoundsBehavior {
	public abstract Rectangle2D.Double getBounds(GameObject gameObject);
}
