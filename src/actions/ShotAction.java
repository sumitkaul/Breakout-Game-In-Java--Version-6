package actions;

import java.util.UUID;

import utilities.Actions;
import utilities.Event;
import game.Game;
import game.GameObject;
import gameMaker.GameMaker;
import interfaces.Action;

public class ShotAction implements Action {
	
	@Override
	public void act(GameObject gameObject) {
		
		
		Game.getSharedGame().getBoard().setCurrentLayer(gameObject.getLayer());
		GameObject newGameObject = GameMaker.getInstance().createNewObject("s2.png","shot","shot", gameObject.getLayer());
		newGameObject.setX(gameObject.getX());
		newGameObject.setY(gameObject.getY()-10);
		newGameObject.setXSpeed(0);
		newGameObject.setYSpeed(-2);
		newGameObject.addAction(Event.NEW_FRAME.getEventCode(), new NormalMoveAction(), "");
		newGameObject.addAction(Event.COLLISION_AGAINST.getEventCode(), new RemoveAction(), "");
		for(GameObject obj : Game.getSharedGame().getGameObjects()) {
			  if(obj!=newGameObject && obj!=gameObject) {
				  
				  obj.addAction(Event.COLLISION_AGAINST.getEventCode(), new RemoveAction(), newGameObject.getName());
			  }
		  }
		
	}

	@Override
	public Actions getActionType() {
		
		return Actions.SHOT;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		
		
	}

	@Override
	public String getAgainstObjectName() {
	
		return null;
	}

}
