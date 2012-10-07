package game;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import CustomObjects.ImageFrame;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>GameControllerTest</code> contains tests for the class <code>{@link GameController}</code>.
 *
 * @author Ritesh
 *  
 * @version $Revision: 1.0 $
 */
public class GameControllerTest {
	/**
	 * Run the GameController() constructor test.
	 *
	 *  
	 */
	@Test
	public void testGameController_1()
		throws Exception {
		GameController result = new GameController();
		assertNotNull(result);
		 
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testActionPerformed_1()
		throws Exception {
		GameController fixture = new GameController();
		ActionEvent actionEvent = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(actionEvent);

		 
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testActionPerformed_2()
		throws Exception {
		GameController fixture = new GameController();
		ActionEvent actionEvent = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(actionEvent);

		 
	}

	/**
	 * Run the void keyPressed(KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testKeyPressed_1()
		throws Exception {
		GameController fixture = new GameController();
		KeyEvent e = new KeyEvent(new ImageFrame(), 1, 1L, 1, 1);

		fixture.keyPressed(e);

		 
	}

	/**
	 * Run the void keyReleased(KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testKeyReleased_1()
		throws Exception {
		GameController fixture = new GameController();
		KeyEvent e = new KeyEvent(new ImageFrame(), 1, 1L, 1, 1);

		fixture.keyReleased(e);

		 
	}

	/**
	 * Run the void keyTyped(KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testKeyTyped_1()
		throws Exception {
		GameController fixture = new GameController();
		KeyEvent e = new KeyEvent(new ImageFrame(), 1, 1L, 1, 1);

		fixture.keyTyped(e);

		 
	}

	/**
	 * Run the void keyTyped(KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testKeyTyped_2()
		throws Exception {
		GameController fixture = new GameController();
		KeyEvent e = new KeyEvent(new ImageFrame(), 1, 1L, 1, 1);

		fixture.keyTyped(e);

		 
	}

	/**
	 * Run the void sendEventToGameObjects(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSendEventToGameObjects_1()
		throws Exception {
		GameController fixture = new GameController();
		int event = 1;

		fixture.sendEventToGameObjects(event);

		 
	}

	/**
	 * Run the void sendEventToGameObjects(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSendEventToGameObjects_2()
		throws Exception {
		GameController fixture = new GameController();
		int event = 1;

		fixture.sendEventToGameObjects(event);

		 
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 *  
	 */
	@Before
	public void setUp()
		throws Exception {
		 
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 *  
	 */
	@After
	public void tearDown()
		throws Exception {
		 
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 *  
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameControllerTest.class);
	}
}