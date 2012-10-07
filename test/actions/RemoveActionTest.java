package actions;

import org.junit.*;
import utilities.Actions;
import game.GameObject;
import static org.junit.Assert.*;

/**
 * The class <code>RemoveActionTest</code> contains tests for the class <code>{@link RemoveAction}</code>.
 *
 * @author Ritesh
 *  
 * @version $Revision: 1.0 $
 */
public class RemoveActionTest {
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
		RemoveAction fixture = new RemoveAction();
		GameObject gameObject = new GameObject();

		fixture.act(gameObject);

		// add additional test code here
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
		RemoveAction fixture = new RemoveAction();

		Actions result = fixture.getActionType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("REMOVE", result.name());
		assertEquals("REMOVE", result.toString());
		assertEquals(2, result.ordinal());
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
		RemoveAction fixture = new RemoveAction();

		String result = fixture.getAgainstObjectName();

		// add additional test code here
		assertEquals(null, result);
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
		RemoveAction fixture = new RemoveAction();
		String againstObjectName = "";

		fixture.setAgainstObjectName(againstObjectName);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(RemoveActionTest.class);
	}
}