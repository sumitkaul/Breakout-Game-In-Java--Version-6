package utilities;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>LayersTest</code> contains tests for the class <code>{@link Layers}</code>.
 * @author Ritesh
 * @version $Revision: 1.0 $
 */
public class LayersTest {
	/**
	 * Run the Layers() constructor test.
	 * @throws Exception
	 */
	@Test
	public void testLayers_1()
		throws Exception {

		Layers result = new Layers();

		assertNotNull(result);
		assertEquals("Layer 1", result.addNewLayer());
	}

	/**
	 * Run the String addNewLayer() method test.
	 * @throws Exception
	 */
	@Test
	public void testAddNewLayer_1()
		throws Exception {
		Layers fixture = new Layers();
		fixture.setLayers(new ArrayList<String>());

		String result = fixture.addNewLayer();

		assertEquals("Layer 0", result);
	}

	/**
	 * Run the Layers getInstance() method test.
	 * @throws Exception
	 */
	@Test
	public void testGetInstance_1()
		throws Exception {

		Layers result = Layers.getInstance();

		assertNotNull(result);
		assertEquals("Layer 1", result.addNewLayer());
	}

	/**
	 * Run the Layers getInstance() method test.
	 * @throws Exception
	 */
	@Test
	public void testGetInstance_2()
		throws Exception {

		Layers result = Layers.getInstance();

		assertNotNull(result);
		assertEquals("Layer 2", result.addNewLayer());
	}

	/**
	 * Run the List<String> getLayers() method test.
	 * @throws Exception
	 */
	@Test
	public void testGetLayers_1()
		throws Exception {
		Layers fixture = new Layers();
		fixture.setLayers(new ArrayList<String>());

		List<String> result = fixture.getLayers();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void setLayers(List<String>) method test.
	 * @throws Exception
	 */
	@Test
	public void testSetLayers_1()
		throws Exception {
		Layers fixture = new Layers();
		fixture.setLayers(new ArrayList<String>());
		List<String> layers = new ArrayList<String>();

		fixture.setLayers(layers);

	}

	/**
	 * Perform pre-test initialization.
	 * @throws Exception
	 *         if the initialization fails for some reason
	 */
	@Before
	public void setUp()
		throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 */
	@After
	public void tearDown()
		throws Exception {
	}

	/**
	 * Launch the test.
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(LayersTest.class);
	}
}