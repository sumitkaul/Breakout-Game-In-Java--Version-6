package actions;

import org.junit.*;
import utilities.Actions;
import game.GameObject;
import static org.junit.Assert.*;

/**
 * The class <code>CheckOverlapActionTest</code> contains tests for the class <code>{@link CheckOverlapAction}</code>.
 *
 * @author Ritesh
 *  
 * @version $Revision: 1.0 $
 */
public class CheckOverlapActionTest {
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
		CheckOverlapAction fixture = new CheckOverlapAction();
		GameObject gameObject = new GameObject();
		gameObject.addToCheckTypeList("");

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
		CheckOverlapAction fixture = new CheckOverlapAction();
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
	public void testAct_3()
		throws Exception {
		CheckOverlapAction fixture = new CheckOverlapAction();
		GameObject gameObject = new GameObject();
		gameObject.addToCheckTypeList("");

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
	public void testAct_4()
		throws Exception {
		CheckOverlapAction fixture = new CheckOverlapAction();
		GameObject gameObject = new GameObject();
		gameObject.addToCheckTypeList("");

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
	public void testAct_5()
		throws Exception {
		CheckOverlapAction fixture = new CheckOverlapAction();
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
	public void testAct_6()
		throws Exception {
		CheckOverlapAction fixture = new CheckOverlapAction();
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
	public void testAct_7()
		throws Exception {
		CheckOverlapAction fixture = new CheckOverlapAction();
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
	public void testAct_8()
		throws Exception {
		CheckOverlapAction fixture = new CheckOverlapAction();
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
		CheckOverlapAction fixture = new CheckOverlapAction();

		Actions result = fixture.getActionType();

		 
		assertNotNull(result);
		assertEquals("CHECK_OVERLAP", result.name());
		assertEquals("CHECK_OVERLAP", result.toString());
		assertEquals(6, result.ordinal());
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
		CheckOverlapAction fixture = new CheckOverlapAction();

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
		CheckOverlapAction fixture = new CheckOverlapAction();
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
		new org.junit.runner.JUnitCore().run(CheckOverlapActionTest.class);
	}
}