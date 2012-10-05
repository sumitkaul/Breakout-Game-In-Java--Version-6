package actions;

import utilities.Actions;
import game.GameObject;
import interfaces.Action;

public class RemoveAction implements Action{

	@Override
	public void act(GameObject gameObject) {
		gameObject.unregisterFromGame();
	}

	@Override
	public Actions getActionType() {
		return Actions.REMOVE;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		
	}

	@Override
	public String getAgainstObjectName() {
		
		return null;
	}

}
