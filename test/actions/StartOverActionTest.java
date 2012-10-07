package actions;

import org.junit.*;
import utilities.Actions;
import game.GameObject;
import static org.junit.Assert.*;

/**
 * The class <code>StartOverActionTest</code> contains tests for the class <code>{@link StartOverAction}</code>.
 *  
 * @author Ritesh
 *
 * @version $Revision: 1.0 $
 */
public class StartOverActionTest {
	/**
	 * Run the void act(GameObject) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testAct_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);
		GameObject gameObject = new GameObject();

		fixture.act(gameObject);

		 
	}

	/**
	 * Run the Actions getActionType() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionType_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);

		Actions result = fixture.getActionType();

		 
		assertNotNull(result);
		assertEquals("START_OVER", result.name());
		assertEquals("START_OVER", result.toString());
		assertEquals(9, result.ordinal());
	}

	/**
	 * Run the String getAgainstObjectName() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetAgainstObjectName_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);

		String result = fixture.getAgainstObjectName();

		 
		assertEquals(null, result);
	}

	/**
	 * Run the int getStartX() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetStartX_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);

		int result = fixture.getStartX();

		 
		assertEquals(1, result);
	}

	/**
	 * Run the int getStartY() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetStartY_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);

		int result = fixture.getStartY();

		 
		assertEquals(1, result);
	}

	/**
	 * Run the void setAgainstObjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetAgainstObjectName_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);
		String againstObjectName = "";

		fixture.setAgainstObjectName(againstObjectName);

		 
	}

	/**
	 * Run the void setStartX(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetStartX_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);
		int startX = 1;

		fixture.setStartX(startX);

		 
	}

	/**
	 * Run the void setStartY(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetStartY_1()
		throws Exception {
		StartOverAction fixture = new StartOverAction();
		fixture.setStartX(1);
		fixture.setStartY(1);
		int startY = 1;

		fixture.setStartY(startY);

		 
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
		new org.junit.runner.JUnitCore().run(StartOverActionTest.class);
	}
}