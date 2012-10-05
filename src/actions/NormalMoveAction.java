package actions;

import utilities.Actions;
import game.GameObject;
import interfaces.Action;

public class NormalMoveAction implements Action {
	@Override
	public void act(GameObject gameObject) {
		double x = gameObject.getX();
		double xSpeed = gameObject.getXSpeed();
		gameObject.setX(x + xSpeed);
		double y = gameObject.getY();
		double ySpeed = gameObject.getYSpeed();
		gameObject.setY(y + ySpeed);
		double heading = gameObject.getHeading();
		double rotationSpeed = gameObject.getRotationSpeed();
		gameObject.setHeading(heading + rotationSpeed);
	}
	
	@Override
	public Actions getActionType() {
		
		return Actions.NORMAL_MOVE;
	}

	@Override
	public void setAgainstObjectName(String againstObjectName) {
	
		
	}

	@Override
	public String getAgainstObjectName() {
		
		return null;
	}

}
