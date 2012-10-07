package utilities;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>EventTest</code> contains tests for the class <code>{@link Event}</code>.
 *
 * @author Ritesh
 *  
 * @version $Revision: 1.0 $
 */
public class EventTest {
	/**
	 * Run the Event(int) constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testEvent_1()
		throws Exception {
		int eventCode = 1;

		Event result = new Event(eventCode);

		 
		assertNotNull(result);
		assertEquals(1, result.getEventCode());
	}

	/**
	 * Run the int getEventCode() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetEventCode_1()
		throws Exception {
		Event fixture = new Event(1);

		int result = fixture.getEventCode();

		 
		assertEquals(1, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
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
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(EventTest.class);
	}
}