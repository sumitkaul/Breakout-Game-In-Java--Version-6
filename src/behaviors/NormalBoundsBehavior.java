package behaviors;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import game.GameObject;
import interfaces.BoundsBehavior;

public class NormalBoundsBehavior implements BoundsBehavior{

	@Override
	public Double getBounds(GameObject gameObject) {
		return new Rectangle2D.Double(gameObject.getX(), gameObject.getY(),
				gameObject.getWidth(), gameObject.getHeight());
	}

}
