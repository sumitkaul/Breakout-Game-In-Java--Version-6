package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Set;

import javax.swing.Timer;

import utilities.Event;
import utilities.Helper;

public class GameController implements ActionListener, KeyListener{
	

	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(GameController.class);

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		LOG.debug(actionEvent.getSource() + " " + actionEvent.paramString()
				+ " " + actionEvent.getID());
		if (actionEvent.getSource().getClass() == Timer.class) {
			LOG.debug("calling newFrame");
			this.newFrame();
		}
	}

	private void newFrame() {
		List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
		for (GameObject obj : gameObjects) {
			LOG.debug("sending new frame event to " + obj.toString());
			obj.sendEvent(Event.NEW_FRAME.getEventCode());
			Set<Integer> objEvents = obj.getEventActionMap().keySet();
			if(objEvents.contains(Event.COLLISION_AGAINST.getEventCode())){
				if(obj.intersectsAny(gameObjects)){
					Helper.getSharedHelper().getGameObjectsToBeRemoved().add(obj);
				}
			}
			if(objEvents.contains(Event.OUT_OF_BOUNDARY.getEventCode())){
				if(isOutOfBoundary(obj)){
					obj.sendEvent(Event.OUT_OF_BOUNDARY.getEventCode());
				}
			}
		}
		for(GameObject obj : Helper.getSharedHelper().getGameObjectsToBeRemoved()){
			obj.sendEvent(Event.COLLISION_AGAINST.getEventCode());
		}
		Helper.getSharedHelper().getGameObjectsToBeRemoved().clear();
		
		Game.getSharedGame().draw();
		
	}

	private boolean isOutOfBoundary(GameObject obj) {
		double posX = obj.getX();
		double speedX = obj.getXSpeed();
		double posY = obj.getY();
		double speedY = obj.getYSpeed();
		if(speedX > 0){
			if((posX - obj.getWidth()) > Game.getSharedGame().getBoard().getWidth()){
				return true;
			}
		}
		else{
			if(posX + obj.getWidth() < 0){
				return true;
			}
		}
		if(speedY > 0){
			if((posY - obj.getHeight()) > Game.getSharedGame().getBoard().getHeight()){
				return true;
			}
		}
		else{
			if(posY + obj.getHeight() < 0){
				return true;
			}
		}
		return false;
	}
	
	public void sendEventToGameObjects(int event) {
		List<GameObject> gameObjects = Game.getSharedGame().getGameObjects();
		for (GameObject obj : gameObjects) {
			LOG.debug("sending " + event + " to " + obj.toString());
			obj.sendEvent(event);
		}
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		LOG.info("key pressed " + e.getKeyCode() + " " + e.getKeyChar());
		this.sendEventToGameObjects(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		if(e.getKeyChar() == 'd'){
			Game.getSharedGame().removeSelectedObject();
		}

	}


}
