package CustomObjects;


import game.Game;
import game.GameObject;
import interfaces.GameObjectObserver;

import java.awt.GridLayout;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

import utilities.Constants;
import utilities.Layers;

import net.miginfocom.swing.MigLayout;




public class PropertiesPanel implements GameObjectObserver{

	private JPanel propertiesPanel;
	private static final org.apache.log4j.Logger LOG =
			org.apache.log4j.Logger.getLogger(PropertiesPanel.class);
	
	private JLabel sizeXLabel;
	private JLabel sizeYLabel;
	private JLabel imageFileLabel;
	private JLabel speedXLabel;
	private JLabel speedYLabel;
	private JLabel layerLabel;
	private JTextField sizeX;
	private JTextField sizeY;
	private JTextField imageFileField;
	private JTextField speedXField;
	private JTextField speedYField;
	private JTextField layerField;
	private String filePath;
	private File imageFile;
	private String shapeString;
	private static PropertiesPanel propertyPanelInstance;
	private DocumentListener documentListener;
	private boolean isNameChanged = false;
	private Board board;
	
	 public boolean isNameChanged() {
		return isNameChanged;
	}


	public void setNameChanged(boolean isNameChanged) {
		this.isNameChanged = isNameChanged;
	}


	public static PropertiesPanel getInstance(){ 
		 LOG.info("Getting static instance of the properties Panel");
	      if(propertyPanelInstance == null) {
	    	  
	    	  propertyPanelInstance = new PropertiesPanel();
	       }
	      return propertyPanelInstance;
		 }		 
	

	public PropertiesPanel(){
		LOG.info("Adding Properties Panel");
		board = Game.getSharedGame().getBoard();
		propertiesPanel = new JPanel();
		//propertiesPanel.setLayout(new GridLayout(12,1));
		propertiesPanel.setLayout(new MigLayout());
		sizeXLabel = new JLabel();
		sizeYLabel = new JLabel();
		imageFileLabel = new JLabel();
		speedXLabel = new JLabel();
		speedYLabel = new JLabel();
		layerLabel = new JLabel("Layer");
		sizeX = new JTextField("",10);
		sizeY = new JTextField("",10);
		imageFileField = new JTextField("",10);
		speedXField = new JTextField("",10);
		speedYField = new JTextField("",10);
		layerField = new JTextField("",10);
		sizeXLabel.setText("SizeX");
		sizeYLabel.setText("SizeY");
		imageFileLabel.setText("Name of the Object");
		speedXLabel.setText("X Speed:");
		speedYLabel.setText("Y Speed:");
		//sizeX.setSize(5, 20);
		//sizeY.setSize(5,20);
		//imageFileField.setSize(5, 20);
		//speedXField.setSize(5, 20);
		//speedYField.setSize(5, 20);
		filePath = "images/";
		
		
		propertiesPanel.add(sizeXLabel,"wrap");
		propertiesPanel.add(sizeX,"wrap,grow");
		propertiesPanel.add(sizeYLabel,"wrap");
		propertiesPanel.add(sizeY,"wrap");
		propertiesPanel.add(imageFileLabel,"wrap");
		propertiesPanel.add(imageFileField,"wrap");
		propertiesPanel.add(speedXLabel,"wrap");
		propertiesPanel.add(speedXField,"wrap");
		propertiesPanel.add(speedYLabel,"wrap");
		propertiesPanel.add(speedYField,"wrap");
		propertiesPanel.add(layerLabel,"wrap");
		propertiesPanel.add(layerField,"wrap");
		propertiesPanel.validate();
		imageFileField.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
				//String name = getImageFileField().getText();
				//Game.getSharedGame().getSelectedGameObject().setName(name);
				LOG.info("In change for image file field");
				isNameChanged = true;
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				
				LOG.info("In insert for image file field");
				isNameChanged = true;
				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
				LOG.info("In remove for image file field");
				isNameChanged = true;
				
			}
			
		});
		sizeX.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			
				//String name = getImageFileField().getText();
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setWidth(Double.parseDouble(sizeX.getText()));
				Game.getSharedGame().getSelectedGameObject().setStartWidth(Double.parseDouble(sizeX.getText()));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
			
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setWidth(Double.parseDouble(sizeX.getText()));
				Game.getSharedGame().getSelectedGameObject().setStartWidth(Double.parseDouble(sizeX.getText()));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setWidth(Double.parseDouble(sizeX.getText()));
				Game.getSharedGame().getSelectedGameObject().setStartWidth(Double.parseDouble(sizeX.getText()));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}
			
		});
		

		Game.getSharedGame().registerForGameObjectUpdates(this);
		

		sizeY.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			
				//String name = getImageFileField().getText();
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setHeight(Double.parseDouble(sizeY.getText()));
				Game.getSharedGame().getSelectedGameObject().setStartHeight(Double.parseDouble(sizeY.getText()));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
			
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setHeight(Double.parseDouble(sizeY.getText()));
				Game.getSharedGame().getSelectedGameObject().setStartHeight(Double.parseDouble(sizeY.getText()));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}			
				}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
			
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setHeight(Double.parseDouble(sizeY.getText()));
				Game.getSharedGame().getSelectedGameObject().setStartHeight(Double.parseDouble(sizeY.getText()));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}
			
		});
		
		speedXField.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			
				//String name = getImageFileField().getText();
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setXSpeed((Double.parseDouble(speedXField.getText())));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
			
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setXSpeed((Double.parseDouble(speedXField.getText())));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}			
				}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setXSpeed((Double.parseDouble(speedXField.getText())));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}				
			}
			
		});

		speedYField.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				
				//String name = getImageFileField().getText();
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setYSpeed((Double.parseDouble(speedYField.getText())));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setYSpeed((Double.parseDouble(speedYField.getText())));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}			
				}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
				try
				{
					LOG.info("in changed update");
				Game.getSharedGame().getSelectedGameObject().setYSpeed((Double.parseDouble(speedYField.getText())));
				board.repaint();
				
				}
				catch (NumberFormatException e)
				{
					LOG.info("Invalid size");
				}				
			}
			
		});

		layerField.getDocument().addDocumentListener(new DocumentListener()
		{

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				LOG.info("in layer changed update");
				if(Layers.getInstance().getLayers().contains(layerField.getText())) {
					if(layerField.getText()==Constants.NEW_LAYER)
						Game.getSharedGame().getSelectedGameObject().setLayer(Layers.getInstance().addNewLayer());
					else
						Game.getSharedGame().getSelectedGameObject().setLayer(layerField.getText());
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				LOG.info("in layer changed update");
				if(Layers.getInstance().getLayers().contains(layerField.getText())) {
					if(layerField.getText()==Constants.NEW_LAYER)
						Game.getSharedGame().getSelectedGameObject().setLayer(Layers.getInstance().addNewLayer());
					else
						Game.getSharedGame().getSelectedGameObject().setLayer(layerField.getText());
				}		
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				LOG.info("in layer changed update");
				if(Layers.getInstance().getLayers().contains(layerField.getText())) {
					if(layerField.getText()==Constants.NEW_LAYER)
						Game.getSharedGame().getSelectedGameObject().setLayer(Layers.getInstance().addNewLayer());
					else
						Game.getSharedGame().getSelectedGameObject().setLayer(layerField.getText());
				}			
			}
			
		});

	}

	public String getShapeString() {
		return shapeString;
	}


	public void setShapeString(String shapeString) {
		this.shapeString = shapeString;
	}


	
	public JPanel getPropertiesPanel() {
		return propertiesPanel;
	}

	public void setPropertiesPanel(JPanel propertiesPanel) {
		this.propertiesPanel = propertiesPanel;
	}
	
	
	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public JLabel getSizeXLabel() {
		return sizeXLabel;
	}

	public void setSizeXLabel(JLabel sizeXLabel) {
		this.sizeXLabel = sizeXLabel;
	}

	public JLabel getSizeYLabel() {
		return sizeYLabel;
	}

	public void setSizeYLabel(JLabel sizeYLabel) {
		this.sizeYLabel = sizeYLabel;
	}

	public JTextField getSizeX() {
		return sizeX;
	}

	public void setSizeX(JTextField sizeX) {
		this.sizeX = sizeX;
	}

	public JTextField getSizeY() {
		return sizeY;
	}

	public void setSizeY(JTextField sizeY) {
		this.sizeY = sizeY;
	}

	public JTextField getImageFileField(){
		return this.imageFileField;
	}
	public JTextField getSpeedXField(){
		return this.speedXField;
	}
	public JTextField getSpeedYField(){
		return this.speedYField;
	}



	@Override
	public void updateProperties() {
		LOG.debug("In Update properties");
		GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
		imageFileField.setText((selectedGameObject.getName()));
		LOG.debug("Name:"+selectedGameObject.getName());
		sizeX.setText(""+selectedGameObject.getWidth());
		sizeY.setText(""+selectedGameObject.getHeight());
		speedXField.setText(""+selectedGameObject.getXSpeed());
		speedYField.setText(""+selectedGameObject.getYSpeed());
		layerField.setText(selectedGameObject.getLayer());
		propertiesPanel.validate();
		
	}
	
	public void clearAll()
	{
		imageFileField.setText("");
		sizeX.setText("");
		sizeY.setText("");
		speedXField.setText("");
		speedYField.setText("");
	}

}
