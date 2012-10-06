package gameMaker;

import game.Game;
import game.GameObject;
import interfaces.Resizable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;

import utilities.ChangeSize;
import utilities.Constants;
import utilities.Event;
import utilities.Layers;
import CustomObjects.Board;
import CustomObjects.EventPanel;
import CustomObjects.ImageFrame;
import CustomObjects.PropertiesPanel;
import actions.ClockAction;

import com.thoughtworks.xstream.XStream;

public class GameMaker implements Resizable
{

	private static GameMaker gameMaker;
	public static GameMaker getInstance() {
		if(gameMaker==null)
			gameMaker = new GameMaker();
		return gameMaker;
	}
	private static JPanel topPanel;

	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(GameMaker.class);
	private JSplitPane verticalPane;
	private JSplitPane propertiesPane;
	private Board board;
	private EventPanel eventPanel;
	private static PropertiesPanel propertiesPanel;
	private JComboBox shapeCombo;
	private File openFile;
	private File saveFile;
	private ChangeSize resizeState;
	private boolean layoutFlag = true;
	private String objectName;
	public static double oldFrameWidth = Constants.FRAME_WIDTH*0.8;
	public static double oldFrameHeight = Constants.FRAME_HEIGHT;
	private ImageFrame imageframe;
	

	public GameMaker() 
	{
		gameMaker = this;
		layoutFlag = true;

		final JFrame baseFrame = new JFrame();
		baseFrame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		baseFrame.getContentPane().setBackground(Color.BLACK);
		baseFrame.setLayout(new BorderLayout());
		baseFrame.setTitle("Breakout");
		baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		baseFrame.setResizable(true);
		baseFrame.setLocationRelativeTo(null);
		LOG.debug("creating new Board");
		board = new Board();
		Game.getSharedGame().setBoard(board);
		board.setBackground(new Color(140,160,170));
		board.setLayout(new BorderLayout());
		eventPanel = EventPanel.getSharedEventPanel();
		propertiesPanel = PropertiesPanel.getInstance();
		topPanel = propertiesPanel.getPropertiesPanel();
		
		///Layout 1 here
		//topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		//topPanel.setLayout(new MigLayout());
		propertiesPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, eventPanel,
				topPanel);
		
		propertiesPane.setTopComponent(topPanel);
		

		propertiesPane.setBottomComponent(eventPanel);
		propertiesPane.setVisible(true);
		propertiesPane.setResizeWeight(0.5);

		shapeCombo = new JComboBox();
		shapeCombo.addItem("Rectangle");
		shapeCombo.addItem("Oval");

		verticalPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, board,
				propertiesPane);
		
		verticalPane.setResizeWeight(0.95);
		verticalPane.setEnabled(false);
		verticalPane.setLeftComponent(board);
		verticalPane.setRightComponent(propertiesPane);
		verticalPane.setVisible(true);
		verticalPane.setDividerSize(10);
		//verticalPane.setResizeWeight(0.8);
		baseFrame.setContentPane(verticalPane);


		Menu fileMenu = new Menu("File");
		MenuItem newInstance = new MenuItem("New");
		fileMenu.add(newInstance);
		MenuItem open = new MenuItem("Open");
		fileMenu.add(open);
		MenuItem save = new MenuItem("Save");
		fileMenu.add(save);
		//MenuItem saveAs = new MenuItem("Save As");
		//fileMenu.add(saveAs);
		MenuItem exit = new MenuItem("Exit");
		fileMenu.add(exit);

		MenuBar menuBar = new MenuBar();
		Menu insertMenu = new Menu("Insert");
		MenuItem customObject = new MenuItem("Custom Object");
		insertMenu.add(customObject);
		MenuItem clock = new MenuItem("Clock");
		insertMenu.add(clock);
		MenuItem backGround = new MenuItem("Background Image");
		insertMenu.add(backGround);
		Menu options = new Menu("Options");
		MenuItem changeLayout = new MenuItem("Change Layout");
		options.add(changeLayout);

		Menu projectMenu = new Menu("Project");
		MenuItem startItem = new MenuItem("Start");
		projectMenu.add(startItem);
		MenuItem stopItem = new MenuItem("Stop");
		projectMenu.add(stopItem);
		
		Menu help = new Menu("Help");
		MenuItem about = new MenuItem("About GameMaker");
		MenuItem userManual = new MenuItem("User Manual");
		help.add(about);
		help.add(userManual);
		
		about.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "This version of GameMaker software is created by Team4\n" +
						"The Developers of this team are Matt, Muthu, Rohan and Ashish\n Hope you like our software. " +
						"Thank You. Enjoy!!!");
				
			}
			
 
		});
		
		userManual.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "GameMaker is a software to create games as per user's requirements.\n" +
						"We have added a few functionalities in this version and would add more in the later ones\n" +
						"The user has to insert an object to begin desiging the game from Insert menu\n" +
						"Then associate that object with the events in the events panel and the correspoding actiosn to be taken for that event.\n" +
						"The events e.gnew frame event which takes place every 10 milisecond as per the timer delay.\n" +
						"The event and associated action are visible in the textfield right below the action combo box.\n" +
						"The user may also mention custom properties in the prooperties Panle that is top right panel before inserting the object.\n" +
						"Once an object is inserted the user can drag and resize teh object to position it.\n" +
						"The event and actions for that obejct can be deleted by selecting that object and the pressing D.\n" +
						"The object can be deleted by hovering mouse over that object and then presiing D." +
						"The game can be started by pressing start from the project menu.\n" +
						"Many other options for the user to explore. Enjoy the software.\n" +
						"This software is free for modification because All Good Things in Life are Free of Cost. Enjoy!!!");
				
			}
			
 
		});


				baseFrame.setMenuBar(menuBar);

		startItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.getSharedGame().getBoard().setCurrentLayer(Constants.ALL_LAYERS);
				Game.getSharedGame().start();
			}
		});
		
		stopItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.getSharedGame().stop();
			}
		});

		newInstance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GameMaker();

			}

		});

		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOG.info("Opening File");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileFilter() {

					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".xml")
								|| f.isDirectory();
					}

					@Override
					public String getDescription() {
						return "XML Files";
					}
				});
				fileChooser.showOpenDialog(new JFrame());
				try {
					openFile = fileChooser.getSelectedFile();
				} catch (NullPointerException noFile) {
					LOG.info("File not selected");
				}
				Board b = Game.getSharedGame().getBoard();
				XStream xstream = new XStream();
				xstream.autodetectAnnotations(true);
				Game game = (Game)xstream.fromXML(openFile);
				game.setSharedGame();
				game.setBoard(b);
				for(String layer : game.getLayer().getLayers()) {
					if(!layer.equals(Constants.NEW_LAYER))
						Layers.getInstance().addNewLayer();
				}
				Game.getSharedGame().getBoard().setCurrentLayer(Constants.ALL_LAYERS);
				game.setFrameDispatcher(new Timer(Constants.FRAME_TIME_MS, Game.getSharedGame().getGameController()));
				b.repaint();
			}
		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOG.info("Saving File");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".xml")
								|| f.isDirectory();
					}

					@Override
					public String getDescription() {
						return "XML Files";
					}
				});
				fileChooser.showSaveDialog(new JFrame());
				try {
					saveFile = fileChooser.getSelectedFile();
				} catch (NullPointerException noFile) {
					LOG.info("File not selected");
				}
				XStream xstream = new XStream();
				xstream.autodetectAnnotations(true);
				FileOutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(saveFile);
				} catch (FileNotFoundException e1) {
					LOG.error(e1.getStackTrace());
				}
				xstream.toXML(Game.getSharedGame(), outputStream);
			}
		});
/*
		saveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOG.info("Saving File");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".xml")
								|| f.isDirectory();
					}

					@Override
					public String getDescription() {
						return "XML Files";
					}
				});
				fileChooser.showSaveDialog(new JFrame());
				try {
					saveFile = fileChooser.getSelectedFile();
				} catch (NullPointerException noFile) {
					LOG.info("File not selected");
				}
			}
		});
		*/
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOG.info("Exiting Applicattion");

			}
		});

		menuBar.add(fileMenu);
		menuBar.add(insertMenu);
		menuBar.add(projectMenu);
		menuBar.add(options);
		menuBar.add(help);
		baseFrame.setMenuBar(menuBar);
		
		
		customObject.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				imageframe = new ImageFrame();
				imageframe.setVisible(true);
			}			
		});
		
		backGround.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				imageframe = new ImageFrame(true);
				imageframe.setVisible(true);
			}			
		});
		
		clock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int sizeX = Constants.CLOCK_X_SIZE;
				int sizeY;
				int speedX;
				int speedY;
				try {
					sizeY = Integer.parseInt(PropertiesPanel.getInstance()
							.getSizeY().getText());
					LOG.debug("got size value for clock y:" + sizeY);

				} catch (NumberFormatException exception) {
					LOG.error("did not read in size values ... using defaults");
					sizeY = 40;
				}
				try {
					speedX = Integer.parseInt(PropertiesPanel.getInstance()
							.getSpeedXField().getText());

					speedY = Integer.parseInt(PropertiesPanel.getInstance()
							.getSpeedYField().getText());
					LOG.debug("got speed values for clock x:" + speedX + " y:" + speedY);
				} catch (NumberFormatException exception) {
					LOG.error("did not read in speed values ... using defaults");
					speedX = 0;
					speedY = 0;
				}
				// If no layers exist, then create new layer
				if(Game.getSharedGame().getBoard().getCurrentLayer().isEmpty())
					Layers.getInstance().addNewLayer();
				GameObject gameObject = new GameObject(180, 10, sizeX, sizeY, speedX, speedY, "","clock","clock","Layer 1");
				Game.getSharedGame().setSelectedGameObject(gameObject);
				ClockAction clockAction = new ClockAction();
				clockAction.act(gameObject);
				gameObject.addAction(Event.NEW_FRAME.getEventCode(), clockAction, "");

				board.repaint();

			}
		});


		baseFrame.setVisible(true);
		
		baseFrame.addComponentListener(new ComponentAdapter() 
		{
            public void componentResized(ComponentEvent e) 
            {
            	Resize(baseFrame.getWidth(), baseFrame.getHeight());
            }
        });
		changeLayout.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (layoutFlag)
				{
					eventPanel.setLayout(new GridLayout(5,1));
					topPanel.setLayout(new GridLayout(8,1));
					layoutFlag = false;
					eventPanel.validate();
					topPanel.validate();
					LOG.info("In Grid Layout");
				}
				else
				{
					eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.PAGE_AXIS));
					topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
					layoutFlag = true;
					eventPanel.validate();
					topPanel.validate();
					LOG.info("In Box Layout");
				
				}
			}

					});

	}
	
	
	public static Area createArea(BufferedImage image, int maxTransparency) {
		Area area = new Area();
		Rectangle rectangle = new Rectangle();
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int rgb = image.getRGB(x, y);
				rgb = rgb >>> 24;
				if (rgb >= maxTransparency) {
					rectangle.setBounds(x, y, 1, 1);
					area.add(new Area(rectangle));
				}
			}
		}
		return area;
	}
	
	public void setResizeState(ChangeSize state)
	{
		this.resizeState = state;
	}
	
	public ChangeSize getResizeState()
	{
		
		return this.resizeState;	
	}

	@Override
	public void Resize(int frameWidth, int frameHeight) 
	{
		 
    	this.setResizeState(ChangeSize.RESIZE);
    	int widthdiff = (int)((frameWidth - Constants.FRAME_WIDTH)*0.8);
		int heightdiff = (frameHeight - Constants.FRAME_HEIGHT);
		verticalPane.validate();
		propertiesPane.validate();
		board.Resize(widthdiff, heightdiff);
		GameMaker.oldFrameHeight = frameHeight;
		GameMaker.oldFrameWidth = frameWidth*0.8;
	}


	public ImageFrame getImageframe() {
		return imageframe;
	}


	public void setImageframe(ImageFrame imageframe) {
		this.imageframe = imageframe;
	}

	public GameObject createNewObject(String filepath, String objecttype, String name, String layer){
		int sizeX;
		int sizeY;
		int speedX;
		int speedY;
	
		try {
			sizeX = Integer.parseInt(PropertiesPanel.getInstance()
					.getSizeX().getText());

			sizeY = Integer.parseInt(PropertiesPanel.getInstance()
					.getSizeY().getText());
			LOG.debug("got size values for customObject x:" + sizeX + " y:" + sizeY);

		} catch (NumberFormatException exception) {
			LOG.error("did not read in size values ... using defaults");
			sizeX = 30;
			sizeY = 30;
		}
		try {
			speedX = Integer.parseInt(PropertiesPanel.getInstance()
					.getSpeedXField().getText());

			speedY = Integer.parseInt(PropertiesPanel.getInstance()
					.getSpeedYField().getText());
			LOG.debug("got speed values for customObject x:" + speedX + " y:" + speedY);
		} catch (NumberFormatException exception) {
			LOG.error("did not read in speed values ... using defaults");
			speedX = 1;
			speedY = 1;
		}
		try {
			if (PropertiesPanel.getInstance().isNameChanged())
			{
			objectName = name;//PropertiesPanel.getInstance().getImageFileField().getText();
			PropertiesPanel.getInstance().setNameChanged(false);
			}
			else
			{
				LOG.error("No Object name inserted");
				LOG.error("Setting defaults");
				//objectName = UUID.randomUUID().toString();
				objectName = name;//PropertiesPanel.getInstance().getImageFileField().getText();
				PropertiesPanel.getInstance().getImageFileField().setText(objectName);
			}
			LOG.debug("Retrieving object Name from Name Field");
			
		}
		catch (Exception exception) {
			LOG.error("Exception");
			//objectName = UUID.randomUUID().toString();
		}

		GameObject gameObject = new GameObject(100, 100, sizeX, sizeY, speedX, speedY, filepath, objecttype, name, layer);
		Game.getSharedGame().setSelectedGameObject(gameObject);
		Game.getSharedGame().getSelectedGameObject().setName(objectName);
		LOG.info("The Name of the Object is " + objectName);

		board.repaint();
		
		return gameObject;
	}
}
