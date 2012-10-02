package game;

import static org.junit.Assert.*;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import game.GameObject;
import org.junit.Before;
import org.junit.Test;

public class GameObjectTest {
	private GameObject gameObject;
	@Before
	public void setUp() throws Exception {
		gameObject = new GameObject(40, 40, 20, 20, 1, 1, new String("image/circleBlack.png"),"test","test","Layer 1");
	}
	
	@Test
	public void testAddEvent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddAction() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSendEvent() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIntersects() {
		boolean result;
		result = gameObject.intersects(new Rectangle2D.Double(30, 30, 20, 20));
		assert(result==true);
	}

}
