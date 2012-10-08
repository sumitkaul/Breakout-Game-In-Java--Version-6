package game;

import gameMaker.GameMaker;
import interfaces.Action;
import interfaces.BoundsBehavior;
import interfaces.DrawBehavior;
import interfaces.Resizable;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import utilities.ActionObject;
import utilities.Constants;
import utilities.Event;
import CustomObjects.Board;
import behaviors.ImageDrawBehavior;
import behaviors.NormalBoundsBehavior;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class GameObject implements Resizable
{
	
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(GameObject.class);
	private double xPosition;
	private double yPosition;
	private double xSpeed;
	private double ySpeed;
	private double height;
	private double width;

	private double rotationSpeed; // Rotation speed ... will affect heading
	private double heading; // in degrees, 0-360
	private String imageFile;
	@XStreamOmitField
	private BufferedImage image;
	private Shape shape;
	private String name;
	private BoundsBehavior boundsBehavior;

	private double startObjectHeight;
	private double startObjectWidth;
	private double startObjectX;
	private double startObjectY;

	private DrawBehavior drawBehavior;
	private String objecttype;
	private String layer;


	private Board board;

	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}


	private HashMap<Integer, List<ActionObject>> eventActionMap;
	private List<String> checkTypeList;

	public GameObject() { // default constructor
		xPosition = 0;
		yPosition = 0;
		xSpeed = 1;	//Default speed
		ySpeed = 1;	//Default speed
		height = 10;
		width = 10;

		initialize();
	}


	public GameObject(double xPosition, double yPosition, double width,
			double height, double xSpeed, double ySpeed, String imageName, String objecttype,String name, String layer) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.name = name;
		this.height = height;
		this.width = width;
		this.imageFile = imageName;
		this.drawBehavior = new ImageDrawBehavior();
		this.image = null;
		this.objecttype=objecttype;
		this.layer = layer;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/"+imageFile));
		} catch (IOException e){
			LOG.warn("image " + imageFile + " not found");
			getDefaultImage();
		}
		initialize();
	}
	
	
	private void getDefaultImage() {
			this.setImageFile(Constants.DEFAULT_IMAGE_FILE);
	}

	public void initialize() {
		this.eventActionMap = new HashMap<Integer, List<ActionObject>>();
		this.checkTypeList = new ArrayList<String>();
		this.boundsBehavior = new NormalBoundsBehavior();
		registerToGame();
		startObjectHeight = this.getHeight();
		startObjectWidth = this.getWidth();
		startObjectX = this.getX();
		startObjectY = this.getY();
		if(!Game.getSharedGame().getGameType().contains(objecttype)){
			Game.getSharedGame().setGameType(objecttype);
		}
	}

	public void draw(Graphics g) {
		this.drawBehavior.draw(this, g);
	}

	public void registerToGame() {
		Game.getSharedGame().addGameObject(this);
	}
	
	public void unregisterFromGame() {
		Game.getSharedGame().removeGameObject(this);
	}

	public void addEvent(int event) {
		if (!this.eventActionMap.containsKey(event)) {
			this.eventActionMap.put(event, new ArrayList<ActionObject>());
		}
	}

	public void addAction(int event, Action action, String againstObjectName) {
		this.addEvent(event);
		List<ActionObject> actionList = this.eventActionMap.get(event);
		ActionObject actionObject = new ActionObject();
		actionObject.setAction(action);
		actionObject.setGameObjectName(againstObjectName);
		actionList.add(actionObject);
		LOG.info("added new action " + action + " for event " + event + " for object " + this);
	}

	public void sendEvent(int event) {

		List<ActionObject> actionList = this.eventActionMap.get(event);
		if (actionList == null){
			LOG.debug("no actions for event:" + event + " in object:" + this.toString());
			return;
		}
		for (ActionObject actionObject : actionList) {
			LOG.debug("executing action for event:" + event);
			actionObject.getAction().setAgainstObjectName(actionObject.getGameObjectName());
			actionObject.getAction().act(this);
		}
		board.repaint();
	}
	

	public String toString() {
		String thisObjectString = new String();
		thisObjectString += "name:" + name;
		thisObjectString += " x:" + this.xPosition;
		thisObjectString += " y:" + this.yPosition;
		thisObjectString += " speedX:" + this.getXSpeed();
		thisObjectString += " speedY:" + this.getYSpeed();
		return thisObjectString;
	}

	public boolean intersects(Rectangle2D rect) {
		Rectangle2D.Double gameRect = new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		return gameRect.intersects(rect);
	}
	

	
	public boolean intersectsAny(List<GameObject> gameObjects){
		int maxX = Game.getSharedGame().getBoard().getWidth();
		int maxY = Game.getSharedGame().getBoard().getHeight();
		Rectangle2D thisBounds = this.getBounds();
		// Game Wall is a special case. Cannot be handled as a game object as the intersection for wall is different.
		for(ActionObject actionObject : this.eventActionMap.get(Event.COLLISION_AGAINST.getEventCode())) {
			if(actionObject.getGameObjectName().contains(Constants.GAME_WALL)) {
				if(thisBounds.getMaxX()>maxX||thisBounds.getMaxY()>maxY) return true;
				if(thisBounds.getMinX()<0||thisBounds.getMinY()<0) return true;
			}
			for(GameObject obj : gameObjects){
				if(obj.equals(this)) continue;
				if(actionObject.getGameObjectName().contains(obj.getName()))
				if(this.intersects(obj.getBounds())){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void Resize(int widthdiff, int heightdiff) 
	{	
		
		double objectNewWidth = (startObjectWidth + ((widthdiff * startObjectWidth)/(Constants.FRAME_WIDTH*0.8)));
		double objectNewHeight = (startObjectHeight + ((heightdiff * startObjectHeight)/Constants.FRAME_HEIGHT));

		this.setHeight(objectNewHeight);
		this.setWidth(objectNewWidth);
		this.setX(this.getX()*((Constants.FRAME_WIDTH*0.8+widthdiff)/GameMaker.oldFrameWidth));
		this.setY(this.getY()*((Constants.FRAME_HEIGHT+heightdiff)/GameMaker.oldFrameHeight));
		board.repaint();
		
	}

	/***************************************************************************
	 * GETTERS AND SETTERS
	 ****************************************************************************/
	public double getX() {
		return this.xPosition;
	}

	public double getY() {
		return this.yPosition;
	}

	public void setX(double x) {
		this.xPosition = x;
	}

	public void setY(double y) {
		this.yPosition = y;
	}

	public double getHeight() {
		return this.height;
	}

	public double getWidth() {
		return this.width;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Rectangle2D getBounds() {
		return this.boundsBehavior.getBounds(this);
	}

	public void setXSpeed(double xspeed) {
		this.xSpeed = xspeed;
	}

	public void setYSpeed(double yspeed) {
		this.ySpeed = yspeed;
	}

	public void setRotationSpeed(double zspeed) {
		this.rotationSpeed = zspeed;
	}

	public double getXSpeed() {
		return this.xSpeed;
	}

	public double getYSpeed() {
		return this.ySpeed;
	}

	public double getRotationSpeed() {
		return this.rotationSpeed;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public double getHeading() {
		return this.heading;
	}

	public void setImageFile(String filename) {
		this.imageFile = filename;
		BufferedImage curimage = this.image;
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/"+imageFile));
		} catch (IOException e){
			LOG.warn("image " + imageFile + " not found");
			this.image = curimage;
		}
	}

	public String getImageFile() {
		return this.imageFile;
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	public BufferedImage getImage(){
		return this.image;
	}

	public Shape getShape() {
		return this.shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public String getName() {
		return name;
	}
	
	public void setStartX(double startX)
	{
		this.startObjectX = startX;
	}
	
	public void setStartY(double startY)
	{
		this.startObjectY = startY;
	}
	
	public void setStartHeight(double startHeight)
	{
		this.startObjectHeight = startHeight;
	}
	
	public void setStartWidth(double startWidth)
	{
		this.startObjectWidth = startWidth;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<Integer, List<ActionObject>> getEventActionMap(){
		return this.eventActionMap;
	}
	
	public void setBoundsBehavior(BoundsBehavior behavior){
		this.boundsBehavior = behavior;
	}
	
	public void setEventActionMap(HashMap<Integer,List<ActionObject>> eventActionMap){
		this.eventActionMap = eventActionMap;
	}

	public DrawBehavior getDrawBehavior(){
		return this.drawBehavior;
	}
	
	public void setDrawBehavior(DrawBehavior db){
		this.drawBehavior = db;

	}

	public String getObjecttype() {
		return objecttype;
	}
	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}
	public List<String> getCheckTypeList() {
		return checkTypeList;
	}
	public void addToCheckTypeList(String type) {
		this.checkTypeList.add(type);
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}

}
