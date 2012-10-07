package CustomObjects;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomComboBoxTest {

	CustomComboBox customComboBox;
	ArrayList<String> stringArraylist = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		customComboBox = new CustomComboBox(stringArraylist, "title");
	}

	@After
	public void tearDown() throws Exception {
		customComboBox = null;
	}

	@Test
	public void testTitle() {
		customComboBox.setTitle("title");
		String actual = customComboBox.getTitle();
		String expected = "title";
		assertTrue(expected.equals(actual));
	}

}