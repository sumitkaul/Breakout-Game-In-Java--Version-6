package utilities;

import org.junit.*;
import actions.AddFlagAction;
import interfaces.Action;
import static org.junit.Assert.*;

/**
 * The class <code>ActionObjectTest</code> contains tests for the class <code>{@link ActionObject}</code>.
 *
 * @author Ritesh
 *  
 * @version $Revision: 1.0 $
 */
public class ActionObjectTest {
	/**
	 * Run the Action getAction() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetAction_1()
		throws Exception {
		ActionObject fixture = new ActionObject();
		fixture.setAction(new AddFlagAction());
		fixture.setGameObjectName("");

		Action result = fixture.getAction();

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the String getGameObjectName() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetGameObjectName_1()
		throws Exception {
		ActionObject fixture = new ActionObject();
		fixture.setAction(new AddFlagAction());
		fixture.setGameObjectName("");

		String result = fixture.getGameObjectName();

		 
		assertEquals("", result);
	}

	/**
	 * Run the void setAction(Action) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetAction_1()
		throws Exception {
		ActionObject fixture = new ActionObject();
		fixture.setAction(new AddFlagAction());
		fixture.setGameObjectName("");
		Action action = new AddFlagAction();

		fixture.setAction(action);

		 
	}

	/**
	 * Run the void setGameObjectName(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetGameObjectName_1()
		throws Exception {
		ActionObject fixture = new ActionObject();
		fixture.setAction(new AddFlagAction());
		fixture.setGameObjectName("");
		String gameObjectName = "";

		fixture.setGameObjectName(gameObjectName);

		 
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
		new org.junit.runner.JUnitCore().run(ActionObjectTest.class);
	}
}