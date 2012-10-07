package actions;

import org.junit.*;
import utilities.Actions;
import game.GameObject;
import static org.junit.Assert.*;

/**
 * The class <code>AddQuestionMActionTest</code> contains tests for the class <code>{@link AddQuestionMAction}</code>.
 *
 * @author Ritesh
 *  
 * @version $Revision: 1.0 $
 */
public class AddQuestionMActionTest {
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
		AddQuestionMAction fixture = new AddQuestionMAction();
		GameObject gameObject = new GameObject();

		fixture.act(gameObject);

		 
	}

	/**
	 * Run the void act(GameObject) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testAct_2()
		throws Exception {
		AddQuestionMAction fixture = new AddQuestionMAction();
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
		AddQuestionMAction fixture = new AddQuestionMAction();

		Actions result = fixture.getActionType();

		 
		assertNotNull(result);
		assertEquals("REPLACE2", result.name());
		assertEquals("REPLACE2", result.toString());
		assertEquals(8, result.ordinal());
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
		AddQuestionMAction fixture = new AddQuestionMAction();

		String result = fixture.getAgainstObjectName();

		 
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
		AddQuestionMAction fixture = new AddQuestionMAction();
		String againstObjectName = "";

		fixture.setAgainstObjectName(againstObjectName);

		 
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
		new org.junit.runner.JUnitCore().run(AddQuestionMActionTest.class);
	}
}