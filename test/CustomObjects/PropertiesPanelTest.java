package CustomObjects;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertiesPanelTest {

	PropertiesPanel panel;
	
@Before
public void setUp() throws Exception {

     panel =new PropertiesPanel();
}

@After
public void tearDown() throws Exception {
	panel = null;
}


@Test
public void testIsNameChanged() {
PropertiesPanel.getInstance().setNameChanged(true);
assertEquals("Is the name changed", true, PropertiesPanel.getInstance().isNameChanged());

}

@Test
public void testSetNameChanged() {

}

@Test
public void testPropertiesPanel() {

}

@Test
public void testGetShapeString() {

}

@Test
public void testSetShapeString() {

}

@Test
public void testGetPropertiesPanel() {

}

@Test
public void testSetPropertiesPanel() {

}

@Test
public void testGetImageFile() {

}

@Test
public void testSetImageFile() {

}

@Test
public void testGetFilePath() {

}

@Test
public void testSetFilePath() {

}

@Test
public void testGetSizeXLabel() {

}

@Test
public void testSetSizeXLabel() {

}

@Test
public void testGetSizeYLabel() {

}

@Test
public void testSetSizeYLabel() {

}

@Test
public void testGetSizeX() {

}

@Test
public void testSetSizeX() {

}

@Test
public void testGetSizeY() {

}

@Test
public void testSetSizeY() {

}

@Test
public void testGetImageFileField() {

}

@Test
public void testGetSpeedXField() {

}

@Test
public void testGetSpeedYField() {

}

@Test
public void testUpdateProperties() {

}

@Test
public void testClearAll() {

}

}