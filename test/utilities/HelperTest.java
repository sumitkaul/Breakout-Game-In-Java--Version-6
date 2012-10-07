package utilities;

import java.util.ArrayList;
import CustomObjects.CustomComboBox;
import game.GameObject;
import interfaces.Action;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>HelperTest</code> contains tests for the class <code>{@link Helper}</code>.
 *  
 * @author Ritesh
 *
 * @version $Revision: 1.0 $
 */
public class HelperTest {
	/**
	 * Run the Helper() constructor test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testHelper_1()
		throws Exception {

		Helper result = new Helper();

		 
		assertNotNull(result);
		assertEquals(0, result.getCurrentKeyCode());
	}

	/**
	 * Run the CustomComboBox createComboBox(ArrayList<String>,String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testCreateComboBox_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		ArrayList<String> listItems = new ArrayList();
		String title = "";

		CustomComboBox result = fixture.createComboBox(listItems, title);

		 
		assertNotNull(result);
		assertEquals("", result.getTitle());
		assertEquals(null, result.getAssociatedEventType());
		assertEquals("PanelUI", result.getUIClassID());
		assertEquals(true, result.isOpaque());
		assertEquals(0.48387095f, result.getAlignmentX(), 1.0f);
		assertEquals(0.5f, result.getAlignmentY(), 1.0f);
		assertEquals(false, result.getAutoscrolls());
		assertEquals(null, result.getComponentPopupMenu());
		assertEquals(0, result.getDebugGraphicsOptions());
		assertEquals(false, result.getInheritsPopupMenu());
		assertEquals(null, result.getInputVerifier());
		assertEquals(null, result.getNextFocusableComponent());
		assertEquals(null, result.getTopLevelAncestor());
		assertEquals(null, result.getTransferHandler());
		assertEquals(true, result.isDoubleBuffered());
		assertEquals(false, result.isManagingFocus());
		assertEquals(true, result.isOptimizedDrawingEnabled());
		assertEquals(false, result.isPaintingForPrint());
		assertEquals(false, result.isPaintingTile());
		assertEquals(true, result.isRequestFocusEnabled());
		assertEquals(false, result.isValidateRoot());
		assertEquals(false, result.requestDefaultFocus());
		assertEquals(false, result.requestFocusInWindow());
		assertEquals(null, result.getGraphics());
		assertEquals(null, result.getRootPane());
		assertEquals(0, result.getHeight());
		assertEquals(0, result.getWidth());
		assertEquals(null, result.getToolTipText());
		assertEquals(true, result.getVerifyInputWhenFocusTarget());
		assertEquals(null, result.getBorder());
		assertEquals(0, result.getX());
		assertEquals(0, result.getY());
		assertEquals(2, result.getComponentCount());
		assertEquals(null, result.getFocusTraversalPolicy());
		assertEquals(false, result.isFocusCycleRoot());
		assertEquals(2, result.countComponents());
		assertEquals(false, result.isFocusTraversalPolicySet());
		assertEquals(false, result.isFocusTraversalPolicyProvider());
//		assertEquals("CustomObjects.CustomComboBox[,0,0,0x0,invalid,layout=javax.swing.BoxLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=297,maximumSize=,minimumSize=,preferredSize=]", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getParent());
		assertEquals(false, result.isValid());
		assertEquals(true, result.isEnabled());
		assertEquals(null, result.getDropTarget());
		assertEquals(null, result.getFocusCycleRootAncestor());
		assertEquals(false, result.isDisplayable());
		assertEquals(false, result.isMaximumSizeSet());
		assertEquals(false, result.isMinimumSizeSet());
		assertEquals(false, result.isPreferredSizeSet());
		assertEquals(null, result.getGraphicsConfiguration());
		assertEquals(null, result.getMousePosition());
		assertEquals(false, result.isLightweight());
		assertEquals(true, result.getFocusTraversalKeysEnabled());
		assertEquals(false, result.getIgnoreRepaint());
		assertEquals(null, result.getInputContext());
		assertEquals(null, result.getInputMethodRequests());
		assertEquals(null, result.getPeer());
		assertEquals(false, result.isFocusOwner());
		assertEquals(true, result.isFocusable());
		assertEquals(false, result.isCursorSet());
		assertEquals(true, result.isFontSet());
		assertEquals(true, result.isVisible());
		assertEquals(false, result.hasFocus());
		assertEquals(false, result.isShowing());
		assertEquals(true, result.isBackgroundSet());
		assertEquals(true, result.isFocusTraversable());
		assertEquals(true, result.isForegroundSet());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_3()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_4()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_5()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_6()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_7()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_8()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_9()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_10()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_11()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_12()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_13()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_14()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_15()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Action getActionForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForId_16()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		Action result = fixture.getActionForId(action);

		 
		assertNotNull(result);
		assertEquals(null, result.getAgainstObjectName());
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_3()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_4()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_5()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_6()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_7()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_8()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_9()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_10()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_11()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_12()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Actions getActionForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionForString_13()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String actionString = "";

		Actions result = fixture.getActionForString(actionString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_3()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_4()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_5()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_6()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_7()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_8()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_9()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_10()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_11()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_12()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String getActionNameForId(Actions) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetActionNameForId_13()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		Actions action = Actions.BOUNCE;

		String result = fixture.getActionNameForId(action);

		 
		assertEquals("Bounce", result);
	}

	/**
	 * Run the String[] getAllActions() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetAllActions_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);

		String[] result = fixture.getAllActions();

		 
		assertNotNull(result);
		assertEquals(12, result.length);
		assertEquals("Normal Move", result[0]);
		assertEquals("Controlled Move", result[1]);
		assertEquals("Remove", result[2]);
		assertEquals("Bounce", result[3]);
		assertEquals("Sound", result[4]);
		assertEquals("Check Overlap", result[5]);
		assertEquals("Replace with Flag", result[6]);
		assertEquals("Replace with ? sign", result[7]);
		assertEquals("Start Over", result[8]);
		assertEquals("Game Over", result[9]);
		assertEquals("Game Win", result[10]);
		assertEquals("Shot", result[11]);
	}

	/**
	 * Run the String[] getAllActions() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetAllActions_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);

		String[] result = fixture.getAllActions();

		 
		assertNotNull(result);
		assertEquals(12, result.length);
		assertEquals("Normal Move", result[0]);
		assertEquals("Controlled Move", result[1]);
		assertEquals("Remove", result[2]);
		assertEquals("Bounce", result[3]);
		assertEquals("Sound", result[4]);
		assertEquals("Check Overlap", result[5]);
		assertEquals("Replace with Flag", result[6]);
		assertEquals("Replace with ? sign", result[7]);
		assertEquals("Start Over", result[8]);
		assertEquals("Game Over", result[9]);
		assertEquals("Game Win", result[10]);
		assertEquals("Shot", result[11]);
	}

	/**
	 * Run the String[] getAllEvents() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetAllEvents_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);

		String[] result = fixture.getAllEvents();

		 
		assertNotNull(result);
		assertEquals(7, result.length);
		assertEquals("New Frame", result[0]);
		assertEquals("Collision Against", result[1]);
		assertEquals("Input", result[2]);
		assertEquals("Mouse left click", result[3]);
		assertEquals("Mouse right click", result[4]);
		assertEquals("Mouse middle click", result[5]);
		assertEquals("Out of Boundary", result[6]);
	}

	/**
	 * Run the String[] getAllEvents() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetAllEvents_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);

		String[] result = fixture.getAllEvents();

		 
		assertNotNull(result);
		assertEquals(7, result.length);
		assertEquals("New Frame", result[0]);
		assertEquals("Collision Against", result[1]);
		assertEquals("Input", result[2]);
		assertEquals("Mouse left click", result[3]);
		assertEquals("Mouse right click", result[4]);
		assertEquals("Mouse middle click", result[5]);
		assertEquals("Out of Boundary", result[6]);
	}

	/**
	 * Run the int getCurrentKeyCode() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetCurrentKeyCode_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);

		int result = fixture.getCurrentKeyCode();

		 
		assertEquals(1, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_3()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_4()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_5()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_6()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_7()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the Event getEventForString(String) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventForString_8()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		String eventString = "";

		Event result = fixture.getEventForString(eventString);

		 
		assertEquals(null, result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_2()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_3()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_4()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_5()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_6()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the String getEventNameForId(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetEventNameForId_7()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int eventcode = 1;

		String result = fixture.getEventNameForId(eventcode);

		 
		assertEquals("Input", result);
	}

	/**
	 * Run the ArrayList<GameObject> getGameObjectsToBeRemoved() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetGameObjectsToBeRemoved_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);

		ArrayList<GameObject> result = fixture.getGameObjectsToBeRemoved();

		 
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Helper getSharedHelper() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetSharedHelper_1()
		throws Exception {

		Helper result = Helper.getSharedHelper();

		 
		assertNotNull(result);
		assertEquals(0, result.getCurrentKeyCode());
	}

	/**
	 * Run the Helper getSharedHelper() method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testGetSharedHelper_2()
		throws Exception {

		Helper result = Helper.getSharedHelper();

		 
		assertNotNull(result);
		assertEquals(0, result.getCurrentKeyCode());
	}

	/**
	 * Run the void setCurrentKeyCode(int) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetCurrentKeyCode_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		int currentKeyCode = 1;

		fixture.setCurrentKeyCode(currentKeyCode);

		 
	}

	/**
	 * Run the void setGameObjectsToBeRemoved(ArrayList<GameObject>) method test.
	 *
	 * @throws Exception
	 *
	 *  
	 */
	@Test
	public void testSetGameObjectsToBeRemoved_1()
		throws Exception {
		Helper fixture = new Helper();
		fixture.setGameObjectsToBeRemoved(new ArrayList());
		fixture.setCurrentKeyCode(1);
		ArrayList<GameObject> gameObjectsToBeRemoved = new ArrayList();

		fixture.setGameObjectsToBeRemoved(gameObjectsToBeRemoved);

		 
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
		// add additional set up code here
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
		new org.junit.runner.JUnitCore().run(HelperTest.class);
	}
}