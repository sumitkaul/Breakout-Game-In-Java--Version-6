package main;
import actions.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActionsTest {

	/**
	 * @throws java.lang.Exception
	 */
	ControlledMoveAction controlledMoveAction;
	CollideBounceAction collideBounceAction;
	GameOverAction gameOverAction;
	GameWinAction gameWinAction;
	PlaySoundAction playSoundAction;
	StartOverAction startOverAction;

	@Before
	public void setUp() throws Exception {
		controlledMoveAction = new ControlledMoveAction(0.0,0.0);
		collideBounceAction = new CollideBounceAction();
		gameOverAction = new GameOverAction();
		gameWinAction = new GameWinAction();
		playSoundAction = new PlaySoundAction();
		startOverAction = new StartOverAction();
	}

	@After
	public void tearDown() throws Exception {
		controlledMoveAction = null;
		collideBounceAction = null;
		gameOverAction = null;
		gameWinAction = null;
		playSoundAction = null;
		startOverAction = null;
	}

	@Test
	public void testXSpeed() {
		controlledMoveAction.setXSpeed(6.0);
		double actual = controlledMoveAction.getXSpeed();
		double expected = 6.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testYSpeed() {
		controlledMoveAction.setYSpeed(8.0);
		double actual = controlledMoveAction.getYSpeed();
		double expected = 8.0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testCollideBounce() {
		collideBounceAction.setAgainstObjectName("Collide");
		String actual = collideBounceAction.getAgainstObjectName();
		String expected = "Collide";
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testGameOver() {
		gameOverAction.setAgainstObjectName("GAME OVER");
		String actual = gameOverAction.getAgainstObjectName();
		String expected = "GAME OVER";
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testGameWin() {
		gameWinAction.setAgainstObjectName("WINNER");
		String actual = gameWinAction.getAgainstObjectName();
		String expected = "WINNER";
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testPlaySound() {
		playSoundAction.setClipName("bounce");
		String actual = playSoundAction.getClipName();
		String expected = "bounce";
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testStartX() {
		startOverAction.setStartX(0);
		int actual = startOverAction.getStartX();
		int expected = 0;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testStartY() {
		startOverAction.setStartY(0);
		int actual = startOverAction.getStartY();
		int expected = 0;
		assertEquals(expected, actual, 0);
	}

}
