package CustomObjects;

import game.Game;
import game.GameObject;
import interfaces.Resizable;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import utilities.Constants;
import utilities.Event;
import utilities.Layers;


public class Board extends JPanel implements Resizable 
{

	/**
	 * 
	 */
	private static final org.apache.log4j.Logger LOG =
			org.apache.log4j.Logger.getLogger(Board.class);
	private static final long serialVersionUID = 1L;
	BindMouseMove movingAdapt = new BindMouseMove();
	ResizeHandler gameobjectResize = new ResizeHandler();
	String backGroundImagePath;
	
	public String getBackGroundImagePath() {
		return backGroundImagePath;
	}

	public void setBackGroundImagePath(String backGroundImagePath) {
		this.backGroundImagePath = backGroundImagePath;
	}

	private String currentLayer;
	
	public Board() {
		this.setDoubleBuffered(true);
		addMouseMotionListener(movingAdapt);
        addMouseListener(movingAdapt);
        addMouseWheelListener(gameobjectResize);
        addKeyListener(Game.getSharedGame().getGameController());
        setFocusable(true);
        currentLayer="";
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
		if(backGroundImagePath != null){
			Image background = new ImageIcon(getClass().getResource("/"+backGroundImagePath)).getImage();
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
		}
		if(currentLayer.equals(Constants.ALL_LAYERS)) {
			/** This for loop ensures that the objects are drawn in increasing order of layers
			*  so that the objects in the top most layer draw on top of the objects in the bottom layers
			*/
			for(String layer : Layers.getInstance().getLayers()) {	
				for (GameObject gameObject : gameObjects) {
					gameObject.setBoard(this);
					if(gameObject.getLayer().equals(layer))
						gameObject.draw(g);
				}
			}
		} else {
			for (GameObject gameObject : gameObjects) {
				gameObject.setBoard(this);
				if(gameObject.getLayer().equals(currentLayer))
					gameObject.draw(g);
			}
		}
	}


	
	class BindMouseMove extends MouseAdapter {
	    private int x;
	    private int y;
	    @Override
	    	public void mousePressed(MouseEvent event) {
	    	switch(event.getModifiers()) {
	        case InputEvent.BUTTON1_MASK: {
	        	x = event.getX();
	    		y = event.getY();
	    		
	    		List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
	    		
	    		for(GameObject gameObject:gameObjects){
	    			if (gameObject.getBounds().contains(x, y)) {
	    				Game.getSharedGame().setSelectedGameObject(gameObject);
	    				if(Game.getSharedGame().getFrameDispatcher().isRunning()){
	    				Game.getSharedGame().getGameController().sendEventToGameObjects(Event.MOUSE_LEFT_CLICK.getEventCode());
	    				}
	    				LOG.info("A Gameobject is selected & left clicked");
	    				PropertiesPanel.getInstance().updateProperties();
	    				EventPanel.getSharedEventPanel().updateProperties();
	    			}
	    			else{
	    				PropertiesPanel.getInstance().clearAll();
	    			}
	    		}
	    		requestFocus();  
	          break;
	          }
	        case InputEvent.BUTTON2_MASK: {
	        	x = event.getX();
	    		y = event.getY();
	    		
	        	List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
	    		
	    		for(GameObject gameObject:gameObjects){
	    			if (gameObject.getBounds().contains(x, y)) {
	    				Game.getSharedGame().setSelectedGameObject(gameObject);
	    				if(Game.getSharedGame().getFrameDispatcher().isRunning()){
	    				Game.getSharedGame().getGameController().sendEventToGameObjects(Event.MOUSE_MIDDLE_CLICK.getEventCode());
	    				}
	    				LOG.info("A Gameobject is selected & Double clicked");
	    			}
	    			else{
	    				PropertiesPanel.getInstance().clearAll();
	    			}
	    		}
	    		requestFocus();  
	          break;
	          }
	        case InputEvent.BUTTON3_MASK: {
	        	x = event.getX();
	    		y = event.getY();
	    		
	    		List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
	    		
	    		for(GameObject gameObject:gameObjects){
	    			if (gameObject.getBounds().contains(x, y)) {
	    				Game.getSharedGame().setSelectedGameObject(gameObject);
	    				if(Game.getSharedGame().getFrameDispatcher().isRunning()){
	    				Game.getSharedGame().getGameController().sendEventToGameObjects(Event.MOUSE_RIGHT_CLICK.getEventCode());
	    				}
	    				LOG.info("A Gameobject is selected & Right clicked");
	    			}
	    			else{
	    				PropertiesPanel.getInstance().clearAll();
	    			}
	    		}
	    		requestFocus(); 
	          break;
	          }
	        }

	    	}
	    
	    
	    	@Override
	    	public void mouseDragged(MouseEvent event) {
	    		int dx = event.getX() - x;
	    		int dy = event.getY() - y;
	    		double tempx;
	    		double tempy;
	    		
	    		GameObject selectedGameObject = Game.getSharedGame().getSelectedGameObject();
	    		
	    		if(selectedGameObject!=null) {
					LOG.info("Mouse dragged on Game Object "+selectedGameObject.getName());
		    		tempx = selectedGameObject.getX();
					tempx += dx;
					selectedGameObject.setX(tempx);
					selectedGameObject.setStartX(tempx);
					tempy = selectedGameObject.getY();
					tempy += dy;
					selectedGameObject.setY(tempy);
					selectedGameObject.setStartY(tempy);
					repaint();
					
		    		x += dx;
		    		y += dy;
		    		PropertiesPanel.getInstance().updateProperties();
	    		}
	    	}
	}
	
	class ResizeHandler implements MouseWheelListener {
		@Override
	    public void mouseWheelMoved(MouseWheelEvent e) 
		{
	        int x = e.getX();
	        int y = e.getY();
	        double tempheight;
	        double tempwidth;
	        if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) 
	        {
	        	List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
	    		for(GameObject gameObject:gameObjects)
	    		{		
	 
	    			if (gameObject.getBounds().contains(x, y)) 
	    			{
	    				float amount = e.getWheelRotation() * 5f;
	    				tempwidth = gameObject.getWidth();
	    				tempwidth += amount;
	    				gameObject.setWidth(tempwidth);
	    				gameObject.setStartWidth(tempwidth);
	    				tempheight = gameObject.getHeight();
	    				tempheight += amount;
	    				gameObject.setHeight(tempheight);
	    				gameObject.setStartHeight(tempheight);
	    				repaint();
	    			}
	    		}
	        }
	    }
	}

	
	@Override
	public void Resize(int widthdiff, int heightdiff) 
	{
		
		LOG.info("width diff = "+widthdiff);
		LOG.info("heightdiff = "+heightdiff);
		List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
		for(GameObject gameObject:gameObjects)
		{
			gameObject.Resize(widthdiff, heightdiff);
		}
	}

	public String getCurrentLayer() {
		return currentLayer;
	}

	public void setCurrentLayer(String layer) {
		this.currentLayer = layer;
		EventPanel.getSharedEventPanel().getLayerComboBox().setSelectedItem(layer);
	}
	
}
