package game;

import interfaces.GameObjectObserver;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.Timer;

import utilities.Constants;
import utilities.Layers;
import CustomObjects.Board;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Game 
{
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(Game.class);
	private static Game sharedGame;
	private GameController gameController;
	private Timer frameDispatcher;
	private List<GameObject> gameObjects;
	private GameObject selectedGameObject;
	private ArrayList<GameObjectObserver> gameObjectObservers;
	private List<String> gameType;
	private Layers layer;
	
	@XStreamOmitField
	private Board board;
	

	public static Game getSharedGame() {
		if (sharedGame == null) {
			sharedGame = new Game();
		}
		return sharedGame;
	}
	public void setSharedGame(){
		Game.sharedGame = this;
	}

	public Game() {
		setGameController(new GameController());
		frameDispatcher = new Timer(Constants.FRAME_TIME_MS, gameController);
		this.gameObjects = new ArrayList<GameObject>();
		this.gameType = new ArrayList<String>();
		this.layer = Layers.getInstance();
	}

	public Layers getLayer() {
		return layer;
	}
	public void setLayer(Layers layer) {
		this.layer = layer;
	}
	public void addGameObject(GameObject gameObject) {
		if (gameObject == null) {
			LOG.debug("gameObject is null");
		}
		this.gameObjects.add(gameObject);
		LOG.debug("new gameObject registered");
	}
	
	public void removeSelectedGameObject(){
		this.gameObjects.remove(selectedGameObject);
	}

	public void addButton(JButton Button, Container c) {

	}
	
	public void removeGameObject(GameObject gameObject){
		this.gameObjects.remove(gameObject);
	}

	public void addContainer(Container c, Container containingContainer) {

	}

	public void draw() {
		board.repaint();
	}

	public List<GameObject> getGameObjects() {
		return this.gameObjects;
	}

	public void start() {
		frameDispatcher.start();
	}

	public void stop() {
		frameDispatcher.stop();
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return this.board;
	}
	
	public Timer getFrameDispatcher() {
		return frameDispatcher;
	}
	public void setFrameDispatcher(Timer frameDispatcher) {
		this.frameDispatcher = frameDispatcher;
	}

	public GameObject getSelectedGameObject() {
		return selectedGameObject;
	}

	public void setSelectedGameObject(GameObject selectedGameObject) {
		this.selectedGameObject = selectedGameObject;
		int count = 0;
		for(GameObjectObserver observer : gameObjectObservers){
			LOG.info("Updating the observer"+ ++count+"upon user click on an object.");
			observer.updateProperties();
		}
	}
	
	public void registerForGameObjectUpdates(GameObjectObserver observer){
		if(gameObjectObservers == null)
			gameObjectObservers = new ArrayList<GameObjectObserver>();
		LOG.info("Registering observer "+observer.toString()+" for selected object update.");
		gameObjectObservers.add(observer);
	}
	public GameController getGameController() {
		return gameController;
	}
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	public void removeSelectedObject() {
		removeGameObject(getSelectedGameObject());
		board.repaint();
	}
	public List<String> getGameType() {
		return gameType;
	}
	public void setGameType(String type) {
		this.gameType.add(type);
	}
	
	public GameObject getGameObjectByName(String name) {
		for(GameObject obj : getGameObjects()) {
			if(obj.getName().equalsIgnoreCase(name))
				return obj;
		}
		LOG.error("No object with the name "+name+"found");
		return null;
	}

}
