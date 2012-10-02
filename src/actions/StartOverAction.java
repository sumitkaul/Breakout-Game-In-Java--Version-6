package actions;

import utilities.Actions;
import game.GameObject;
import interfaces.Action;

public class StartOverAction implements Action {
	
	private int startX, startY;

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	@Override
	public void act(GameObject gameObject) {
		gameObject.setX(startX);
		gameObject.setY(startY);

	}

	@Override
	public Actions getActionType() {
		return Actions.START_OVER;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAgainstObjectName() {
		// TODO Auto-generated method stub
		return null;
	}

}
