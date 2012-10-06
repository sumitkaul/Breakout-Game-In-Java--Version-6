package main;
import game.GameObject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameObjectTest {

	/**
	 * @throws java.lang.Exception
	 */
	GameObject gameObject;

	@Before
	public void setUp() throws Exception {
		gameObject = new GameObject(0.0,0.0,0.0,0.0,0.0,0.0,"","","","");
	}

	@After
	public void tearDown() throws Exception {
		gameObject = null;
	}

	@Test
	public void testHeight() {
		gameObject.setHeight(20.0);
		double actual = gameObject.getHeight();
		double expected = 20.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testWidth() {
		gameObject.setWidth(10.0);
		double actual = gameObject.getWidth();
		double expected = 10.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testX() {
		gameObject.setX(100.0);
		double actual = gameObject.getX();
		double expected = 100.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testY() {
		gameObject.setY(300.0);
		double actual = gameObject.getY();
		double expected = 300.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testYSpeed() {
		gameObject.setYSpeed(5.0);
		double actual = gameObject.getYSpeed();
		double expected = 5.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testXSpeed() {
		gameObject.setXSpeed(7.0);
		double actual = gameObject.getXSpeed();
		double expected = 7.0;
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testRotationSpeed() {
		gameObject.setRotationSpeed(3.0);
		double actual = gameObject.getRotationSpeed();
		double expected = 3.0;
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testName() {
		gameObject.setName("tank");
		String actual = gameObject.getName();
		String expected = "tank";
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testLayer() {
		gameObject.setLayer("one");
		String actual = gameObject.getLayer();
		String expected = "one";
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testObjectType() {
		gameObject.setObjecttype("rectangle");
		String actual = gameObject.getObjecttype();
		String expected = "rectangle";
		assertTrue(expected.equals(actual));
	}

}
