package behaviors;

import java.awt.Graphics;
import java.awt.Image;

import game.GameObject;
import interfaces.DrawBehavior;

public class ImageDrawBehavior implements DrawBehavior {
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
	.getLogger(ImageDrawBehavior.class);

	@Override
	public void draw(GameObject gameObject, Graphics g) {
		LOG.debug("in draw, height:" + gameObject.getHeight() + " width:" + gameObject.getWidth());
		if(gameObject.getImage()==null){
			gameObject.setImageFile(gameObject.getImageFile());
		}
		g.drawImage((Image)gameObject.getImage(), (int)gameObject.getX(), (int)gameObject.getY(), 
				(int)gameObject.getWidth(), (int)gameObject.getHeight(), null);
	}

}
